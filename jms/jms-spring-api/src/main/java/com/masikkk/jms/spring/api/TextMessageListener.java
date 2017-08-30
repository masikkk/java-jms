package com.masikkk.jms.spring.api;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TextMessageListener implements MessageListener{
	//消息到达后系统自动调用监听器的onMessage()方法
	@Override
	public void onMessage(Message message) {
		try {
			if(message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage)message;
				String messageString = textMessage.getText();
				System.out.println("Spring 异步收到消息：" + messageString);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
