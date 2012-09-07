package com.lkan.sample.person;

import com.lkan.sample.mapReduce.MapReduceResult;

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
