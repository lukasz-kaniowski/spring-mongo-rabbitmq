package com.lkan.sample.person;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Person repository
 *
 * @author Lukasz Kaniowski
 */
public interface PersonRepository extends MongoRepository<Person, String> {

}
