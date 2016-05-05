package com.frankstar.springStudy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FourthSpring {

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("instantiatingBean.xml");
		HelloApi bean = beanFactory.getBean("bean", HelloApi.class);
		bean.sayHello();
	}

}
