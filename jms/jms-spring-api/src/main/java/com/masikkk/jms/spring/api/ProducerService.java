package com.masikkk.jms.spring.api;

import javax.jms.Destination;

public interface ProducerService {
	//向成员目的地destination发送文本消息message
	public void sendTextMessage(final String message);
	
	//向指定目的地destination发送文本消息message
	public boolean sendTextMessage(Destination destination, final String message);
	
	//向成员目的地destination发送字节消息byteMsg
	public void sendBytesMessage(final byte[] byteMsg);
	
	//向指定目的地destination发送字节消息byteMsg
	public boolean sendBytesMessage(Destination destination, final byte[] byteMsg);	
}
