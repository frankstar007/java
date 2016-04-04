/**
 * 
 */
package com.frankstar.Thread;

import java.util.Date;

/**
 * @author frankstar
 *
 */
public class ThreadJoin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestJoinThread tjt = new TestJoinThread("frankstar");
		tjt.start();//启动
		try {
			tjt.join();//将子线程合并到主线程,合并线程后，程序的执行的过程就相当于是方法的调用的执行过程
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i <= 5; i++) {
			System.out.println("I am mainThread!");
		}
	}

}

class TestJoinThread extends Thread {
	//构造方法
	public TestJoinThread(String name) {
		super(name);
	}
	
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println("I am at " + getName() + " time at " + new Date().toLocaleString());
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
	
}