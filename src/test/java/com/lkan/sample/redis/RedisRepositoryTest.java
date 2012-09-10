package com.lkan.sample.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * TODO lkan; javadoc
 *
 * @author Lukasz Kaniowski
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/redis.xml")
public class RedisRepositoryTest {

	@Autowired
	RedisRepository redisRepository;

	@Test
	public void shouldSaveStringValue() throws Exception {
		//given
		redisRepository.save("key", "value");
		//when
		//then
		assertThat(redisRepository.get("key")).isEqualTo("value");
	}


	@Test
	public void shouldCountSaves() throws Exception {
		//given
		redisRepository.clearCounter();
		//when
		redisRepository.save("key", "value");
		redisRepository.save("key2", "value2");
		//then
		assertThat(redisRepository.getOperationCount()).isEqualTo(2L);
	}


}
