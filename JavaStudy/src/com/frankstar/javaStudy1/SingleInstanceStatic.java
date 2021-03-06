/**
 * 
 */
package com.frankstar.javaStudy1;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author frankstar
 *利用静态内部类
 */
public class SingleInstanceStatic {
	private SingleInstanceStatic(){
		
	}
	
	private static SingleInstanceStatic getInstance() {
		return SingleInstanceHolder.sInstance;
	}
	
	private static class SingleInstanceHolder {
		private static SingleInstanceStatic sInstance = new SingleInstanceStatic(); 
	}
}
