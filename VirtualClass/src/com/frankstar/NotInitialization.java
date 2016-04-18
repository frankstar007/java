/**
 * 
 */
package com.frankstar;

/**
 * @author frankstar
 * @function Java虚拟机类加载机制
 */
class SSClass {
	static {
		System.out.println("SSClass");
	}
}
class SuperClass extends SSClass {
	static {
		System.out.println("SuperClass init!");
	}
	public static int value = 123;
	public SuperClass() {
		System.out.println("init SuperClass!");
	}
}
class SubClass extends SuperClass {
	static {
		System.out.println("SubClass init!");
	}
	public static int a;
	public SubClass() {
		System.out.println("init SubClass!");
	}
}
class ConstClass {
	static {
		System.out.println("ConstClass init!");
	}
	public static final String HELLOWORLD = "hello, frankstar!";
}
public class NotInitialization {

	public static void main(String[] args) {
		//System.out.println(SubClass.value);
		//SuperClass[] sca = new SuperClass[10];
		System.out.println(ConstClass.HELLOWORLD);
	}

}
