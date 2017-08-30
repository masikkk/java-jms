package com.masikkk.jms.spring.api;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

public class ConsumerSyncImpl implements ConsumerSync {
	private JmsTemplate jmsTemplate;
	private Destination destination;
	
	@Override
	public void receiveTextMessage() {
		Message message = null;
		try {
			//receive方法同步收取消息，收到消息前会阻塞等待
			message = jmsTemplate.receive(destination);
			if(null != message) {
				if(message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage)message;
					System.out.println("Spring同步收到消息："+textMessage.getText());
				}
			}				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
}
