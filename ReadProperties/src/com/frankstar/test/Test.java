/**
 * 
 */
package com.frankstar.test;

/**
 * @author frankstar
 *   对象的2种比较方法 == 与  equals 的区别
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "foo";
		String b = "foo";
		
		String c = new String("foo");
		String d = new String("foo");
		String e = a;
		System.out.println(a == b);
		System.out.println(c == d);
		System.out.println(e == a);

	}

}
