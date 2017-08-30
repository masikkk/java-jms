package com.masikkk.jms.spring.api;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ProducerServiceImpl implements ProducerService{
	private JmsTemplate jmsTemplate;
	private Destination destination;
	
	@Override
	//向成员目的地destination发送文本消息message
	public void sendTextMessage(final String message) {
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});	
	}

	@Override
	//向指定目的地destination发送文本消息message
	public boolean sendTextMessage(Destination destination, final String message) {
		boolean ret=true;
		try {
			jmsTemplate.send(destination, new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage(message);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			ret = false;
		}
		return ret;
	}


	@Override
	//向成员目的地destination发送字节消息byteMsg
	public void sendBytesMessage(final byte[] byteMsg) {
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				BytesMessage bytesMessage = session.createBytesMessage();
				bytesMessage.writeBytes(byteMsg);
				return bytesMessage;
			}
		});	
	}


	@Override
	//向指定目的地destination发送字节消息byteMsg
	public boolean sendBytesMessage(Destination destination, final byte[] byteMsg) {
		boolean ret=true;
		try {
			jmsTemplate.send(destination, new MessageCreator() {
				public Message createMessage(Session session) throws JMSException {
					BytesMessage bytesMessage = session.createBytesMessage();
					bytesMessage.writeBytes(byteMsg);
					return bytesMessage;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			ret = false;
		}
		return ret;
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
