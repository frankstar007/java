/**
 * 
 */
package com.frankstar.javaExam;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author frankstar
 * @function 通过反射实例化一个类
 */
class Students {
	private String name;
	private int age;
	public Students() {
		super();
	}
	public Students(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	//覆盖toString 方法
	public String toString(){
		return "student:" + name + " age:" + age;
	}
}
public class NewInstanceTest {

	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//使用无参的构造函数
		Class<Students> clazz = Students.class;
		//System.out.println(clazz);
		Students stu1 = clazz.newInstance();
		System.out.println(stu1);
		//Students stu2 = clazz.newInstance("frank",25);
		Constructor<Students> constructor = clazz.getConstructor(String.class,int.class);
		stu1 = constructor.newInstance("frankstar",25);
		System.out.println(stu1);
	}

}
