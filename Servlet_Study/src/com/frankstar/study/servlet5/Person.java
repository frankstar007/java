package com.frankstar.study.servlet5;

public class Person {
	private String name;
	private int age;
	public Person(){}
	public Person(String name, int age) {
		this.setAge(age);
		this.setName(name);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
