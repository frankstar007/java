/**
 * 
 */
package com.frankstar.Thread;

/**
 * @author frankstar
 * 使用Runnable接口实现多线程
 */
public class MyRunnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableImplement ri1 = new RunnableImplement("frank");
		RunnableImplement ri2 = new RunnableImplement("star");
		
		Thread t1 = new Thread(ri1);
		Thread t2 = new Thread(ri2);
		
		t2.start();
		t1.start();
	}

}
