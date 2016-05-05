package com.frankstar.springStudy.DI;

import com.frankstar.springStudy.HelloImpl2;

public class TestPrototype {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建Bean工厂
		DefaultBeanFactory beanFactory = new DefaultBeanFactory();
		//创建原型Bean定义
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setId("bean");
		beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
		beanDefinition.setClazz(HelloImpl2.class.getName());
		beanFactory.registerBeanDefinition(beanDefinition);
		//对于返回一个全新的Bean
		System.out.println(beanFactory.getBean("bean") != beanFactory.getBean("bean"));
	}

}
