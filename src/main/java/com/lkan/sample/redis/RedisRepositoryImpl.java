package com.lkan.sample.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO lkan; javadoc
 *
 * @author Lukasz Kaniowski
 */
@Repository
public class RedisRepositoryImpl implements RedisRepository {


	private static final String PUB_SUB_MSG = "pub_sub_msg";
	private final StringRedisTemplate stringRedisTemplate;
	private final ValueOperations<String, String> valueOps;
	private final RedisAtomicLong counter;


	@Autowired
	public RedisRepositoryImpl(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;
		valueOps = stringRedisTemplate.opsForValue();
		counter = new RedisAtomicLong("counter", stringRedisTemplate.getConnectionFactory());
	}

	@Override
	public void save(String key, String value) {
		valueOps.set(key, value);
		counter.incrementAndGet();
	}

	@Override
	public String get(String key) {
		return valueOps.get(key);
	}

	@Override
	public Long getOperationCount() {
		return counter.get();
	}

	@Override
	public void clearCounter() {
		counter.set(0L);
	}

	@Override
	public void saveMessage(String msg) {
		stringRedisTemplate.opsForList().leftPush(PUB_SUB_MSG, msg);
	}

	@Override
	public void flushDb() {
		stringRedisTemplate.getConnectionFactory().getConnection().flushDb();
	}

	@Override
	public List<String> getMessages() {
		return stringRedisTemplate.opsForList().range(PUB_SUB_MSG, 0, -1);
	}


}
