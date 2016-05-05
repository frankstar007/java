package com.frankstar.springStudy.DI;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MoreDependencyInject {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ResourceBean.xml");
		//一点要注册销毁回调 否则我们定义的销毁方法不执行
		context.registerShutdownHook();
		DependentBean dependentBean = context.getBean("dependentBean", DependentBean.class);
		dependentBean.write("frankstar");
	}

}
