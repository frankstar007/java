package com.frankstar.springStudy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("List.xml");
		ListTestBean listTestBean = beanFactory.getBean("listBean", ListTestBean.class);
		System.out.println(listTestBean.getValues());
		CollectionTestBean collectionTestBean = beanFactory.getBean("setBean", CollectionTestBean.class);
		System.out.println(collectionTestBean.getValues());
		ArrayTest arrayTest = beanFactory.getBean("arrBean", ArrayTest.class);
		System.out.println(arrayTest.getArr());
	}

}
