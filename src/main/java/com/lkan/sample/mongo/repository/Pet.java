package com.lkan.sample.mongo.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * TODO lkan; javadoc
 *
 * @author Lukasz Kaniowski
 */
@Document
public class Pet {
	public enum Type {
		CAT, DOG
	}


	@Id
	private String id;

	private String name;

	private Type type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
