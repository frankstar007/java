package com.frankstar;

import java.util.Date;

public class SuperTest extends Date{
	private static final long serialVersionUID = 1L;
	private void test() {
		System.out.println(super.getClass().getName());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SuperTest().test();
	}

}
