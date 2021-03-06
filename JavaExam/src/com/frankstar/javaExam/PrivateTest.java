/**
 * 
 */
package com.frankstar.javaExam;

import java.lang.reflect.Field;

/**
 * @author frankstar
 * @function 使用反射访问类的私有成员 调用setAccessible(true)
 */
class PrivateTestClass {
	private String name;
	
	public PrivateTestClass(String name) {
		super();
		this.name = name;
	}
}
public class PrivateTest {

	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		PrivateTestClass obj = new PrivateTestClass("frankstar");
		Class clazz = obj.getClass();
		System.out.println(clazz);
		Field field = clazz.getDeclaredField("name");
		field.setAccessible(true);
		System.out.println(field.get(obj));
		
	}

}
