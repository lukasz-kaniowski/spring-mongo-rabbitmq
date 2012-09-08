package com.lkan.sample.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Person repository
 *
 * @author Lukasz Kaniowski
 */
public interface PersonRepository extends MongoRepository<Person, String>, PersonRepositoryCustom {

	Person findByName(String name);

	@Query("{ 'name' : ?0 }")
	List<Person> findQueryExample(String name);
}
