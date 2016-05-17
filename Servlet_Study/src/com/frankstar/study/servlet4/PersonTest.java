package com.frankstar.study.servlet4;

import com.sun.javafx.css.PseudoClassState;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		//注册监听person对象行为的监听器
		person.registerListener(new PersonListener() {
			
			@Override
			public void dorun(Event event) {
				// TODO Auto-generated method stub
				Person person = event.getPerson();
				System.out.println(person + "在跑步！");
			}
			
			@Override
			public void doeat(Event event) {
				// TODO Auto-generated method stub
				Person person = event.getPerson();
				System.out.println(person + "在吃东西！");
			}
		});
		person.eat();
		person.run();
	}

}
