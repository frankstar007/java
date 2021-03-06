package com.frankstar.javaExam;

import java.lang.reflect.Field;

//使用反射覆盖数据对象的toString方法
class DataObject {
	private String name;
	private String desc;
	private String other;
	private int age;
	//带参的构造函数
	public DataObject(String name, String desc, String other, int age) {
		this.age = age;
		this.desc = desc;
		this.other = other;
		this.name = name;
	}
	//覆盖toString 方法
	public String toString() {
		StringBuffer sBuffer  = new StringBuffer();
		//得到所有的成员变量
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			sBuffer.append(field.getName());
			sBuffer.append("=");
			try {
				sBuffer.append(field.get(this));
				
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} 
			sBuffer.append("\n");
			
		}
		return sBuffer.toString();
	}
}
public class DataObjectTest {
	
	public static void main(String[] args) {
		//创建一个对象
		DataObject object = new DataObject("frankstar", "good boy!", "keep studying!", 25);
		System.out.println(object);
	}

}
