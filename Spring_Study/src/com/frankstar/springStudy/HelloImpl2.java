package com.frankstar.springStudy;

public class HelloImpl2 implements HelloApi{
	private String message;
	public HelloImpl2() {
		this.message = "hello i am num1!";
	}
	public HelloImpl2(String message) {
		this.message = message;
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

}
