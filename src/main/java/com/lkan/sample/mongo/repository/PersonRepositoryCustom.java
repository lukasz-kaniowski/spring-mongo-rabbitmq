package com.lkan.sample.mongo.repository;

import com.lkan.sample.mongo.mapReduce.MapReduceResult;

import java.util.List;

/**
 * TODO lkan; javadoc
 *
 * @author Lukasz Kaniowski
 */
public interface PersonRepositoryCustom {

	List<Person> complicatedSearch();

	MapReduceResult countPetsForPeopleOlderThan(int age);
}
