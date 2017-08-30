package com.masikkk.jms.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.masikkk.jms.spring.api.ProducerService;

public class ProducerMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"applicationContext-core.xml","applicationContext-producer.xml"});
		ProducerService producerService = (ProducerService)context.getBean("producerService");
		for(int i=0; i<5; i++) {
			producerService.sendTextMessage("Spring JmsTemplate消息："+i);
			System.out.println("Spring JmsTemplate发送消息："+i);
		}
	}
}
