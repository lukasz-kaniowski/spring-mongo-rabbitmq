package com.lkan.sample.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

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

	private int age;

	private List<Pet> pets = new ArrayList<Pet>();

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addPet(Pet pet) {
		pets.add(pet);
	}

	public List<Pet> getPets() {
		return pets;
	}

}
