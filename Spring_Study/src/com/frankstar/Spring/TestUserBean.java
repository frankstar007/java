package com.frankstar.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserBean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//读取配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("UserBean.xml");
		//获取UserBean的实例
		PersonBean personBean = context.getBean("userBean", PersonBean.class);
		personBean.show();
		PersonBean personBeani = context.getBean("userBean", PersonBean.class);
		personBeani.show();
		PersonBean personBean1 = context.getBean("userBean1", PersonBean.class);
		personBean1.show();
		PersonBean personBean1i = context.getBean("userBean1", PersonBean.class);
		personBean1i.show();
		PersonBean personBean2 = context.getBean("userBean2", PersonBean.class);
		personBean2.show();
		PersonBean personBean2i = context.getBean("userBean2", PersonBean.class);
		personBean2i.show();
		PersonBean personBean3 = context.getBean("userBean3", PersonBean.class);
		personBean3.show();
		PersonBean personBean3i = context.getBean("userBean3", PersonBean.class);
		personBean3i.show();
		System.out.println(personBean1i == personBean1);
	}

}
