package com.frankstar.springStudy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SecondSpring {

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("instantiatingBean.xml");
		HelloApi bean1 = (HelloApi) beanFactory.getBean("bean1");
		bean1.sayHello();
		HelloApi bean2 = (HelloApi) beanFactory.getBean("bean2");
		bean2.sayHello();
		HelloApi bean3 = beanFactory.getBean("bean3", HelloApi.class);
		bean3.sayHello();
		HelloApi bean4 = beanFactory.getBean("bean5", HelloApi.class);
		bean4.sayHello();
		
	}

}
