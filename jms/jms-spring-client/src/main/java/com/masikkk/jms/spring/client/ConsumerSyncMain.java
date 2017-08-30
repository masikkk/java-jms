package com.masikkk.jms.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.masikkk.jms.spring.api.ConsumerSync;

public class ConsumerSyncMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"applicationContext-core.xml","applicationContext-consumer-sync.xml"});
		ConsumerSync consumerSync = (ConsumerSync)context.getBean("consumerSync");
		for(int i=0; i<5; i++) {
			consumerSync.receiveTextMessage(); //同步收取消息
		}
	}
}
