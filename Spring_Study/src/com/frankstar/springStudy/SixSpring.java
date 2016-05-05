package com.frankstar.springStudy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SixSpring {

	public static void main(String[] args) {
		//初始化父容器
		ApplicationContext parentBeanContext = new ClassPathXmlApplicationContext("DIBean.xml");
		//初始化当前容器
		ApplicationContext beanApplicationContext = new ClassPathXmlApplicationContext(
				new String[] {"DIBeanSon.xml"}, parentBeanContext);
		HelloApi bean1 = beanApplicationContext.getBean("bean1", HelloApi.class);
		bean1.sayHello();
		HelloApi bean2 = beanApplicationContext.getBean("bean2", HelloApi.class);
		bean2.sayHello();
	}

}
