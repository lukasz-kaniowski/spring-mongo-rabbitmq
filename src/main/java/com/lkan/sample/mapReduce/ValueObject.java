package com.lkan.sample.mapReduce;

import java.util.HashMap;

/**
 * TODO lkan; javadoc
 *
 * @author Lukasz Kaniowski
 */
public class ValueObject {
	private String id;
	private HashMap value;

	public String getId() {
		return id;
	}

	public HashMap getValue() {
		return value;
	}

	public void setValue(HashMap value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ValueObject [id=" + id + ", value=" + value + "]";
	}
}
