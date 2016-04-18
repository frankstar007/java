/**
 * 
 */
package com.frankstar;

/**
 * @author frankstar
 * @function 测是类的加载过程
 *  感觉先加载类的变量（静态变量或这静态代码块）
 */
public class StaticTest {
	public static void main(String[] args) {
		staticFunction();
	}
	
	static {
		System.out.println("1");
	}
	{
		System.out.println("2");
	}
	static StaticTest st = new StaticTest();
	StaticTest() {
		System.out.println("3");
		System.out.println("a="+a+"b="+b);
	}
	public static void staticFunction() {
		System.out.println("4");
	}
	int a = 100;
	static int b = 112;

}
