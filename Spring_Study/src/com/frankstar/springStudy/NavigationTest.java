package com.frankstar.springStudy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NavigationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("navigationBean.xml");
		NavigationA navigationA = applicationContext.getBean("a", NavigationA.class);
		navigationA.getNavigationB().getNaviagtionC().sayNavigation();
		navigationA.getNavigationB().getList().get(0).sayNavigation();
		navigationA.getNavigationB().getMap().get("key").sayNavigation();
		navigationA.getNavigationB().getArray()[0].sayNavigation();
		((NavigationC)navigationA.getNavigationB().getProperties().get("1")).sayNavigation();
	}

}
