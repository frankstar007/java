/**
 * 
 */
package com.frankstar.javaStudy1;

/**
 * @author frankstar
 * 单例的继承 当子类式父类单例类的内部类师
 */
public class BaseSingleton {
	private static volatile BaseSingleton sInstance;
	
	private BaseSingleton() {
		
	}
	
	private static BaseSingleton getInstance() {
		if (null == sInstance) {
			synchronized (BaseSingleton.class) {
				if (null == sInstance) {
					sInstance = new BaseSingleton();
				}
			}
		}
		return sInstance;
	}
	public static class MySingleton extends BaseSingleton {
		
	}
}
