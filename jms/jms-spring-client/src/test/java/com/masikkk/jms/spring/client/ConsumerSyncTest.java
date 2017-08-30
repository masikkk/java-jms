package com.masikkk.jms.spring.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.masikkk.jms.spring.api.ConsumerSync;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-core.xml",
		"classpath:applicationContext-consumer-sync.xml"})
public class ConsumerSyncTest {
	@Autowired
	ConsumerSync consumerSync;
	
	@Test
	public void testConsumerSync() {
		for(int i=0; i<5; i++) {
			consumerSync.receiveTextMessage(); //同步收取消息
		}		
	}
}
