package com.lkan.sample.person;

import com.lkan.sample.mapReduce.MapReduceResult;
import com.lkan.sample.mapReduce.ValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Query;

import javax.management.QueryEval;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * TODO lkan; javadoc
 *
 * @author Lukasz Kaniowski
 */
public class PersonRepositoryImpl implements PersonRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	MongoOperations mongoOperations;


	@Override
	public List<Person> complicatedSearch() {
		return mongoTemplate.findAll(Person.class);
	}

	@Override
	public MapReduceResult countPetsForPeopleOlderThan(int age) {
		MapReduceResult mapReduceResult = new MapReduceResult();
		Query query = new Query(where("age").gt(age));
		MapReduceResults<ValueObject> results = mongoOperations.mapReduce(query, "person", "classpath:mapReduce/petsMap.js", "classpath:mapReduce/petsReduce.js", ValueObject.class);
		for (ValueObject valueObject : results) {
			int count = ((Double) valueObject.getValue().get("count")).intValue();
			mapReduceResult.put(Pet.Type.valueOf(valueObject.getId()), count);
		}
		return mapReduceResult;
	}


}
