package com.lkan.sample.redis;

import org.junit.Before;
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
public class RedisServiceTest {

	@Autowired
	private RedisPublisher redisService;

	@Autowired
	private RedisRepository redisRepository;

	@Before
	public void setup() {
		redisRepository.flushDb();
	}

	@Test
	public void shouldPublishMsgWithoutError() throws Exception {
		redisService.publish("Some message!");
		Thread.sleep(10); //wait for asynchronous call to finish

		assertThat(redisRepository.getMessages().size()).isEqualTo(1);
		assertThat(redisRepository.getMessages().get(0)).isEqualTo("Some message!");
	}

}
