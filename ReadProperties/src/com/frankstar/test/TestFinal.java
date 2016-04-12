/**
 * 
 */
package com.frankstar.test;

/**
 * @author frankstar
 * 测试final关键字
 */
public class TestFinal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int a = 5 + 2;
		final double b = 1.2 / 3;
		final String str = "java" + 99.0;
		final String str2 = "java" + String.valueOf(99.0);
		
		System.out.println(a);
		System.out.println(str);
		System.out.println(str2);
		System.out.println(str == str2);
		
		String str3 = new String("frankstar");
		String str4 = new String("frankstar");
		
		System.out.println(str3 == str4);
		System.out.println(str3.equals(str4));
		System.out.println(str.hashCode());
		System.out.println(str4.hashCode());
				
	}

}
