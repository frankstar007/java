/**
 * 
 */
package com.frankstar.Thread;

/**
 * @author frankstar
 * 用Tread类创建线程 实现run方法
 *
 */
public class ThreadImplement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread mt1 = new MyThread("frank");
		MyThread mt2 = new MyThread("star");
		mt1.start();//开辟新的进程
		mt2.start();
		for (int i = 0; i<= 10; i++) {
			System.out.println("mainMethod:" + i);
		}

	}

}
class MyThread extends Thread {
	public MyThread(String name) {
		super(name);
	}
	//重写实现run方法
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(this.getName() + ":" + i);
		}
		
	}
}
