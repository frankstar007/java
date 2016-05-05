package com.frankstar.springStudy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ThirdSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("instantiatingBean.xml");
		HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
		byIndex.sayHello();
		HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
		byType.sayHello();
		HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
		byName.sayHello();
		HelloApi byIndex2 = beanFactory.getBean("byIndex2", HelloApi.class);
		byIndex2.sayHello();
		HelloApi byType2 = beanFactory.getBean("byType2", HelloApi.class);
		byType2.sayHello();
		HelloApi byName2 = beanFactory.getBean("byName2", HelloApi.class);
		byName2.sayHello();
		HelloApi byIndex3 = beanFactory.getBean("byIndex3", HelloApi.class);
		byIndex3.sayHello();
		HelloApi byType3 = beanFactory.getBean("byType3", HelloApi.class);
		byType3.sayHello();
		HelloApi byName3 = beanFactory.getBean("byName3", HelloApi.class);
		byName3.sayHello();
	}

}
