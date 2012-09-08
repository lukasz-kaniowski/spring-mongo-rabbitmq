package com.lkan.sample.mongo.repository;

import com.lkan.sample.mongo.mapReduce.MapReduceResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static com.lkan.sample.mongo.builder.PersonBuilder.aPerson;
import static com.lkan.sample.mongo.builder.PetBuilder.aCat;
import static com.lkan.sample.mongo.builder.PetBuilder.aDog;
import static java.util.Arrays.asList;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO lkan; javadoc
 *
 * @author Lukasz Kaniowski
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/mongo.xml")
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


	@Test
	public void shouldCountPetsForPeopleAfterGivenAge() throws Exception {
		//given
		personRepository.save(asList(
				aPerson().withAge(10).withPet(aCat().build()).build(),
				aPerson().withAge(30).withPet(aCat().build()).build(),
				aPerson().withAge(31).withPet(aCat().build())
						.withPet(aDog().build()).build(),
				aPerson().withAge(32).withPet(aDog().build()).build()
		));
		//when
		MapReduceResult result = personRepository.countPetsForPeopleOlderThan(29);
		//then
		assertThat(result.get(Pet.Type.DOG)).isEqualTo(2);
		assertThat(result.get(Pet.Type.CAT)).isEqualTo(2);
	}


}
