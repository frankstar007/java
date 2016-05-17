package com.frankstar.study.servlet1;

import java.util.Date;

public class Person {
	//javaBean必须要有一个无参的构造函数 属性必须私有化 私有化属性必须通过public方法暴露给其他程序
	private String name;
	private String sex;
	private int age;
	private boolean married;
	private Date birthday;
	
	public Person() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}