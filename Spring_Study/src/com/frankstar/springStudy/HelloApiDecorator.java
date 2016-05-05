package com.frankstar.springStudy;

public class HelloApiDecorator implements HelloApi{
	private HelloApi helloApi;
	//空构造器
	public HelloApiDecorator() {
	}
	//有参构造器
	public HelloApiDecorator(HelloApi helloApi) {
		this.helloApi = helloApi;
	}
	public void setHelloApi(HelloApi helloApi) {
		this.helloApi = helloApi;
	}
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("－－－－装饰以下－－－－");
		helloApi.sayHello();
		System.out.println("～～～～装饰一下～～～～");
		
	}

}
