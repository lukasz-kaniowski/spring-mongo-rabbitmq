package com.lkan.sample.builder;

import com.lkan.sample.person.Person;

public class PersonBuilder {
	private String name;
	private final Person person;

	public PersonBuilder() {
		person = new Person();
	}

	public static PersonBuilder aPerson() {
		return new PersonBuilder();
	}

	public PersonBuilder withName(String name) {
		person.setName(name);
		return this;
	}

	public Person build() {
		return person;
	}
}