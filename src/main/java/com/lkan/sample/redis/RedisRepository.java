package com.lkan.sample.redis;

import com.lkan.sample.mongo.repository.Person;

import java.util.List;

/**
 * Repository for redis
 *
 * @author Lukasz Kaniowski
 */
public interface RedisRepository {
	/**
	 * Saves value for given key
	 *
	 * @param key
	 * @param value
	 */
	void save(String key, String value);

	/**
	 * Get value for key
	 *
	 * @param key
	 * @return
	 */
	String get(String key);

	/**
	 * Get current value of counter
	 *
	 * @return
	 */
	Long getOperationCount();

	/**
	 * Clears counter
	 */
	void clearCounter();

	/**
	 * Save msg on list for key 'pub_sub_msg'
	 *
	 * @param msg
	 */
	void saveMessage(String msg);

	/**
	 * Get list for key 'pub_sub_msg'
	 *
	 * @return
	 */
	List<String> getMessages();

	/**
	 * Clears redis database
	 */
	void flushDb();
}
