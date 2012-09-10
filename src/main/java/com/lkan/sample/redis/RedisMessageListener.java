package com.lkan.sample.redis;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO lkan; javadoc
 *
 * @author Lukasz Kaniowski
 */
public class RedisMessageListener {

	@Autowired
	private RedisRepository redisRepository;

	public void handleMessage(String msg) {
		redisRepository.saveMessage(msg);
	}
}
