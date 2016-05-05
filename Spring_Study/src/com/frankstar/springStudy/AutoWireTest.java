package com.frankstar.springStudy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("autoLoad.xml");
		HelloApi helloApi = context.getBean("bean", HelloApi.class);
		helloApi.sayHello();
	}

}
