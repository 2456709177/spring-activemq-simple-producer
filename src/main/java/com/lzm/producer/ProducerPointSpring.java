package com.lzm.producer;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class ProducerPointSpring {
	@Autowired
	JmsTemplate jmsTemplate;
	@Qualifier("queueTextDestination")
	@Autowired
	Destination destination;
	
	public void sendMsg(final String msg) {
		jmsTemplate.send(destination, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				
				return session.createTextMessage(msg);
			}
		});
		System.out.println("发送成功....");
	}
	
}
