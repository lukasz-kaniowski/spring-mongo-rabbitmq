package com.lkan.sample.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Publisher using redis.
 *
 * @author Lukasz Kaniowski
 */
@Service
public class RedisPublisher {

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * Publish message
	 *
	 * @param msg
	 */
	public void publish(String msg) {
		redisTemplate.convertAndSend("redis_channel", msg);
	}
}
