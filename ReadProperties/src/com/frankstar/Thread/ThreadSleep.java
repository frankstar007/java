/**
 * 
 */
package com.frankstar.Thread;

import java.util.Date;

/**
 * @author frankstar
 * 线程sleep方法
 */
public class ThreadSleep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestThread tt = new TestThread();
		tt.start();//调用start()方法启动新线程
		try {
			TestThread.sleep(10000);
			System.out.println("主线程睡眠10秒后启动");
			//由于sleep方法属于静态方法，可以使用"类名.静态方法名"或者"对象的引用.静态方法名"
			//在哪个线程中调用了sleep()方法就是让哪个线程睡眠
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		tt.flag = false;//改变循环条件，结束死循环

	}

}

class TestThread extends Thread {
	boolean flag = true;//控制循环的条件
	
	public void run() {
		while(flag) {
			System.out.println(new Date().toLocaleString());
			try {
				sleep(1000);//线程每隔一秒睡一次，然后再次启动该线程
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
