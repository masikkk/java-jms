package com.masikkk.jms.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueSender {
    public static void main( String[] args )
    {
    	ConnectionFactory connectionFactory;
    	Connection connection = null;
    	Session session; // Session，一个发送或接收消息的线程
    	Destination destination;
    	MessageProducer messageProducer;
    	
    	//创建ActiveMQ连接工厂
    	connectionFactory = new ActiveMQConnectionFactory(
    			ActiveMQConnection.DEFAULT_USER, 
    			ActiveMQConnection.DEFAULT_PASSWORD,
    			"tcp://localhost:61616");
    	try {
    		//从连接工厂构造连接
    		connection = connectionFactory.createConnection();
    		//启动连接
    		connection.start();
    		//从连接创建session，事务型session
    		session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
    		//从session创建一个名为"masikkkQueue"的队列
    		destination = session.createQueue("masikkkQueue");
    		//在session中为destination创建一个消息生产者
    		messageProducer = session.createProducer(destination);
    		
    		//发送消息
    		for (int i = 0; i < 5; i++) {
    			//在session中创建一条消息
    			TextMessage textMessage = session.createTextMessage("消息 "+i);
				messageProducer.send(textMessage);
				System.out.println("发送消息："+textMessage.getText());
			}
    		//事务型session需要commit才真正发送
    		session.commit();
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		if(connection != null) {
    			try {
    				connection.close();
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	
    }
}
