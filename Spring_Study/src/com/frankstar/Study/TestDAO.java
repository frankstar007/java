package com.frankstar.Study;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("UserDAO.xml");
		UserService service = context.getBean("userService", UserService.class);
		service.show();
	}

}
