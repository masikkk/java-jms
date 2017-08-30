package com.masikkk.jms.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicReceiverAsync {
	public static void main(String[] args) {
		ConnectionFactory connectionFactory;
		Connection connection = null;
		Session session;
		Destination destination;
		MessageConsumer messageConsumer;
		//创建AMQ连接工厂
		connectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER, 
				ActiveMQConnection.DEFAULT_PASSWORD, 
				"tcp://localhost:61616");
		
		try {
			//从连接工厂构造连接
			connection = connectionFactory.createConnection();
			//启动连接 
			connection.start();
			//从连接创建session，非事务session 
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//从session创建topic，与生产者发送到的主题名一致
			destination = session.createTopic("masikkkTopic");
			//在session中为destination创建一个消息订阅者
			messageConsumer = session.createConsumer(destination);
			//为消费者注册消息监听器
			messageConsumer.setMessageListener(new MyTopicListener());
			System.out.println("消费者消息监听器注册完成");
			Thread.sleep(1000000); //若不sleep程序会直接结束 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null){
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
		}
	}

}

//消息监听类
class MyTopicListener implements MessageListener {
	@Override
	//消息到达后系统自动调用监听器的onMessage()方法
	public void onMessage(Message message) {
		try {
			if(message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage)message;
				String messageString = textMessage.getText();
				System.out.println("异步收到消息：" + messageString);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

