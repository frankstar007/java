package com.frankstar.springStudy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FifthSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("DIBean.xml");
		//通过构造器方式注入
//		HelloApi bean1 = beanFactory.getBean("bean1", HelloApi.class);
//		bean1.sayHello();
		HelloApi bean2 = beanFactory.getBean("bean2", HelloApi.class);
		bean2.sayHello();
	}

}
