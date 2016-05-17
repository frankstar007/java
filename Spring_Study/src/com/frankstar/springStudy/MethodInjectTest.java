package com.frankstar.springStudy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MethodInjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("MethodInject.xml");
		System.out.println("singleton sayhello");
		HelloApi helloApi1 = context.getBean("helloApi1", HelloApi.class);
		helloApi1.sayHello();
//		helloApi1 = context.getBean("helloApi1", HelloApi.class);
//		helloApi1.sayHello();
		System.out.println("prototype sayhello");
		HelloApi helloApi2 = context.getBean("helloApi2", HelloApi.class);
		helloApi2.sayHello();
		//helloApi2 = context.getBean("helloApi2", HelloApi.class);
		
	}

}