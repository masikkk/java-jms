package com.masikkk.jms.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerAsyncMain {
	public static void main(String[] args) {
		//加载Spring上下文后自动开始监听消息
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"applicationContext-core.xml","applicationContext-consumer-async.xml"});
	}
}
