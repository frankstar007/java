package com.frankstar.javaStudy1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
	public static Car initByDefaultConst() throws Throwable {
		//通过类加载器获得Car类对象
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("com.frankstar.javaStudy1.Car");
		
		//获取类的默认构造器对象并通过它实例化Car
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Constructor constructor = clazz.getDeclaredConstructor((Class[])null);
		Car car = (Car) constructor.newInstance();
		
		//通过反射设置属性
		@SuppressWarnings("unchecked")
		Method setBrand = clazz.getMethod("setBrand", String.class);
		setBrand.invoke(car, "兰博基尼");
		@SuppressWarnings("unchecked")
		Method setColor = clazz.getMethod("setColor", String.class);
		setColor.invoke(car, "黑色");
		@SuppressWarnings("unchecked")
		Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
		setMaxSpeed.invoke(car, 500);
		
		return car;
		
	}

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Car car = initByDefaultConst();
		car.introduce();
	}

}
