/**
 * 
 */
package com.frankstar.javaExam;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @author frankstar
 * @function 测试反射的类的成员变量
 */
class FieldTestClass {
	String name;
	int age;
	//构造方法
	public FieldTestClass(String name, int age) {
		super();
		this.age = age;
		this.name = name;	
	}
}
public class FieldTest {

	public static void main(String[] args) {
		FieldTestClass obj1 = new FieldTestClass("frank", 25);
		FieldTestClass obj2 = new FieldTestClass("star", 26);
		
		System.out.println(compare(obj1, obj2).name + " is bigger!");
	}

	private static FieldTestClass compare(FieldTestClass obj1, FieldTestClass obj2) {
		// 通过反射定义一个通用的比较方法 返回age相对更大的对象
		try {
			Field field = obj1.getClass().getDeclaredField("age");
			field = FieldTestClass.class.getDeclaredField("age");
			//获得两个对象的age值
			int val1 = (Integer)field.get(obj1);
			int val2 = (Integer)field.get(obj2);
			if (val1 > val2) {
				return obj1;
			} else {
				return obj2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
