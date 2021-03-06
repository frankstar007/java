/**
 * 
 */
package com.frankstar.javaStudy1;

/**
 * @author frankstar
 * 懒汉式单例模式
 */
public class SingleInstance {
	//定义一个静态的私有的该类类型的field字段
	private static SingleInstance sInstance;
	//私有无参构造器
	private SingleInstance() {
		
	}
	//提供共有的静态访问方法
	public static synchronized SingleInstance getSinstance() {
		if (null == sInstance) {
			synchronized (SingleInstance.class) {
				if (null == sInstance) {
					sInstance = new SingleInstance();
				}
			}
		}
		return sInstance;
	}
}
