package com.frankstar.javaExam;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Student implements Serializable {
	private static final long serialVersionUID = 1l;
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
public class ExamSerializble {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Student student  = new Student();
		student.setName("frankstar");
		student.setAge(25);
		//创建一个输出对象流ObjectOutputStream
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stu.txt"));
		oos.writeObject(student);
		oos.close();
		
		//创建一个输入流对象ObjectInputStream
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stu.txt"));
		Student student2 = (Student) ois.readObject();
		System.out.println(student2.getName());
		System.out.println(student2.getAge());
		
	}

}
