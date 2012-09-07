package com.lkan.sample.builder;

import com.lkan.sample.person.Person;
import com.lkan.sample.person.Pet;

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

	public PersonBuilder withPet(Pet pet){
		person.addPet(pet);
		return this;
	}

	public Person build() {
		return person;
	}
}