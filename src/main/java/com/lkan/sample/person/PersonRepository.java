package com.lkan.sample.person;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * TODO lkan; javadoc
 *
 * @author Lukasz Kaniowski
 */
public interface PersonRepository extends MongoRepository<Person, String> {
}
