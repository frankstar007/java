package com.frankstar.Spring;

public class BeanFactory {
	
	//使用静态工厂方法实例化
	public static PersonBean UserBeanService() {
		return new UserBean();	
	}

	public PersonBean getUserBeanService() {
		return new UserBean();
	}
}