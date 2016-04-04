/**
 * 
 */
package com.frankstar.Thread;

/**
 * @author frankstar
 * 线程优先级测试
 */
public class PriorityThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPriorityThread1 tpt1 = new TestPriorityThread1();
		TestPriorityThread2 tpt2 = new TestPriorityThread2();
		Thread t1 = new Thread(tpt1);
		Thread t2 = new Thread(tpt2);
		
//		t1.start();
//		t2.start();  //先看未设置优先级的进程
//		这里的优先级指的是执行一次的时间会较长即占据CPU时间片的时间会比较多
		t1.setPriority(Thread.NORM_PRIORITY + 3);
		t1.start();
		t2.start();
		
		System.out.println("t1的优先级为: " + t1.getPriority());

	}

}
class TestPriorityThread1 implements Runnable {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 5; i++) {
			System.out.println("1st: " + i);
		}
	}
	
}
class TestPriorityThread2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 5; i++) {
			System.out.println("2st: " + i);
		}
	}
	
}