package com.lkan.sample.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

/**
 * TODO lkan; javadoc
 *
 * @author Lukasz Kaniowski
 */
public class PersonRepositoryImpl implements PersonRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<Person> complicatedSearch() {
		return mongoTemplate.findAll(Person.class);
	}


}
