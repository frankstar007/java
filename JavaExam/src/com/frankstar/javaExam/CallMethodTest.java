package com.frankstar.javaExam;

import java.lang.reflect.Method;

class MethodTestClass{
	public void m1() {
		System.out.println("m1 is called!");
	}
	public void m2() {
		System.out.println("m2 is called!");
	}
}
public class CallMethodTest {

	public static void main(String[] args) {
		args = new String[]{"m2"};
		String methodName = args[0];
		if (methodName != null) {
			//得到Class实例
			Class<MethodTestClass> clazz = MethodTestClass.class;
			try {
				Method method = clazz.getDeclaredMethod(methodName);
				if (method != null) {
					MethodTestClass obj = clazz.newInstance();
					method.invoke(obj);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
