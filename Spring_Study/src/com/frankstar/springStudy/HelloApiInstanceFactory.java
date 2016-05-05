package com.frankstar.springStudy;

public class HelloApiInstanceFactory {
	public HelloApi newInstance(String message) {
		return new HelloImpl2(message);
	}
}
