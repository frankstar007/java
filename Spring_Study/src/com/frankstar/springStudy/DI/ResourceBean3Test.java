package com.frankstar.springStudy.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


public class ResourceBean3Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("resourceBean3");
		ResourceBean3 resourceBean3 = context.getBean("resourceBean1", ResourceBean3.class);
		System.out.println(resourceBean3.geResource() instanceof ClassPathResource);
		//Assert.isInstanceOf(ClassPathResource,resourceBean3.geResource());
	}

}
