package com.lkan.sample.mongo.builder;

import com.lkan.sample.mongo.repository.Pet;

public class PetBuilder {

	private final Pet pet;

	public PetBuilder() {
		pet = new Pet();
	}

	public static PetBuilder aCat() {
		return new PetBuilder().ofType(Pet.Type.CAT);
	}

	public static PetBuilder aDog() {
		return new PetBuilder().ofType(Pet.Type.DOG);
	}

	public PetBuilder ofType(Pet.Type type) {
		pet.setType(type);
		return this;
	}

	public PetBuilder withName(String name) {
		pet.setName(name);
		return this;
	}

	public Pet build() {
		return pet;
	}
}