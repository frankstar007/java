package com.frankstar.springStudy;

public class DependencyInjectByStaticFactory {
	public static HelloApi newInstance(String message, int index) {
		return new HelloImpl3(message, index);
	}
}
