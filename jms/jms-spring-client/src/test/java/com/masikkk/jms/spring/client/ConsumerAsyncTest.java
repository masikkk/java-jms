package com.masikkk.jms.spring.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.masikkk.jms.spring.api.ProducerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-core.xml",
		"classpath:applicationContext-consumer-async.xml",
		"classpath:applicationContext-producer.xml"})
public class ConsumerAsyncTest {
	@Autowired
	ProducerService producerService;

	@Test
	public void testSendTextMessage() {
		//加载applicationContext-consumer-async.xml后监听器自动启动，调producerService发消息即可收到
		for(int i=0; i<5; i++) {
			producerService.sendTextMessage("JUnit测试Spring JMS消息："+i);
			System.out.println("JUnit测试Spring JMS消息："+i);
		}		
	}
}
