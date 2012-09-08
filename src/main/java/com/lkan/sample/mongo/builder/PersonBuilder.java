package com.lkan.sample.mongo.builder;

import com.lkan.sample.mongo.repository.Person;
import com.lkan.sample.mongo.repository.Pet;

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

	public PersonBuilder withAge(int age) {
		person.setAge(age);
		return this;
	}

	public PersonBuilder withPet(Pet pet){
		person.addPet(pet);
		return this;
	}

	public Person build() {
		return person;
	}
}