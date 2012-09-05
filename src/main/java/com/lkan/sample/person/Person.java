package com.lkan.sample.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * TODO lkan; javadoc
 *
 * @author Lukasz Kaniowski
 */
@Document
public class Person {

	@Id
	private String id;

	private String name;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
