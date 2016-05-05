package com.frankstar.springStudy;

public class HelloImpl3 implements HelloApi{
	private String message;
	private int index;
	@java.beans.ConstructorProperties({"message","index"})
	public HelloImpl3(String message, int index) {
		this.index = index;
		this.message = message;
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println(index + ":" + message);
	}

}
