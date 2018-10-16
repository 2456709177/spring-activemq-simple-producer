package com.lzm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lzm.producer.ProducerPointSpring;
import com.lzm.producer.ProducerTopicSpring;

public class JmsTest {
	/**
	 * 点到点消息提供者
	 */
	@Test
	public void pointToPoint() {
		ApplicationContext application=new ClassPathXmlApplicationContext("applicationContext-jms-producer.xml");
		ProducerPointSpring bean = application.getBean(ProducerPointSpring.class);
		bean.sendMsg("spring 测试.....");
		
	}
	/**
	 * 发布订阅消息提供者
	 */
	@Test
	public void releaseSubscription() {
		ApplicationContext application=new ClassPathXmlApplicationContext("applicationContext-jms-producer.xml");
		ProducerTopicSpring bean = application.getBean(ProducerTopicSpring.class);
		bean.sendMsg("spring 发布订阅消息测试.....");
		
	}
}
