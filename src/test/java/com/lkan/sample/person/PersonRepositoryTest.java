package com.lkan.sample.person;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static com.lkan.sample.builder.PersonBuilder.aPerson;
import static com.lkan.sample.builder.PetBuilder.aCat;
import static java.util.Arrays.asList;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO lkan; javadoc
 *
 * @author Lukasz Kaniowski
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class PersonRepositoryTest {

	@Autowired
	PersonRepository personRepository;
	@Autowired
	MongoTemplate mongoTemplate;

	@Before
	public void setup() {
		mongoTemplate.dropCollection("person");
	}

	@Test
	public void shouldCreatePersonInTestDB() throws Exception {
		//given
		Person person = aPerson().withName("name").build();
		//when
		personRepository.save(person);
		//then
		assertThat(personRepository.findAll().get(0).getName()).isEqualTo("name");
	}


	@Test
	public void shouldFindPersonByNameConvention() throws Exception {
		//given
		personRepository.save(asList(
				aPerson().withName("Alfred").build(),
				aPerson().withName("Kate").build()));
		//when
		Person person = personRepository.findByName("Alfred");
		//then
		assertThat(person).isNotNull();
		assertThat(person.getName()).isEqualTo("Alfred");
	}


	@Test
	public void shouldFindPersonByQueryAnnotation() throws Exception {
		//given
		personRepository.save(asList(
				aPerson().withName("Alfred").build(),
				aPerson().withName("Kate").build()));
		//when
		List<Person> persons = personRepository.findQueryExample("Alfred");
		//then
		assertThat(persons.size()).isEqualTo(1);
		assertThat(persons.get(0).getName()).isEqualTo("Alfred");
	}


	@Test
	public void shouldFindPersonByCustomQuery() throws Exception {
		//given
		personRepository.save(asList(
				aPerson().withName("Alfred").build(),
				aPerson().withName("Kate").build()));
		//when
		List<Person> persons = personRepository.complicatedSearch();
		//then
		assertThat(persons.size()).isGreaterThan(0);
	}


	@Test
	public void shouldAddPetToPerson() throws Exception {
		//given
		Person alfred = aPerson().withName("Alfred").withPet(
				aCat().withName("fluffy").build())
				.build();
		//when
		personRepository.save(alfred);
		//then
		assertThat(personRepository.findByName("Alfred").getPets().size()).isEqualTo(1);
	}


}
