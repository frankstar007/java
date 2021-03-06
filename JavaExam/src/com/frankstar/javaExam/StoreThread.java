/**
 * 
 */
package com.frankstar.javaExam;

/**
 * @author frankstar
 * @function 一个生产者对应多个消费者模型
 * 
 */
class Producer extends Thread {
	private StoreThread storeThread;
	public Producer(StoreThread s) {
		this.storeThread = s;
	}
	public void run() {
		while (true) {
			storeThread.add();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Consumer extends Thread {
	private StoreThread storeThread;
	public Consumer(StoreThread s) {
		this.storeThread = s; 
	}
	public void run() {
		while (true) {
			storeThread.remove();
			try {
				Thread.sleep(1500);
			}  catch (InterruptedException e) {
				e.printStackTrace();
			}
 		}
		
	}
}
public class StoreThread {
	private final int MAX_SIZE;
	private int count;
	public StoreThread(int n) {
		MAX_SIZE = n;
		count = 0;
	}
	//往仓库里添加货物
	public synchronized void add() {
		while (count > MAX_SIZE) {
			System.out.println("已经满了！");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count++;
		//打印当前仓库的货物数量
		System.out.println(Thread.currentThread().toString() + "put " + count);
		//仓库中已有获取 请来取
		this.notifyAll();
	}
	//从仓库中取走货物
	public synchronized void remove() {
		while (count < 0) {
			System.out.println("仓库已空！");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//打印当前货物的数量
		System.out.println(Thread.currentThread().toString() + "get " + count);
		count--;
		this.notifyAll();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StoreThread storeThread = new StoreThread(5);
		//创建2个生产者和消费者
		Thread pro1 = new Producer(storeThread);
		Thread pro2 = new Producer(storeThread);
		Thread con1 = new Consumer(storeThread);
		Thread con2 = new Consumer(storeThread);
		pro1.setName("frank");
		pro2.setName("star");
		con1.setName("kelly");
		con2.setName("li");
		//启动
		pro1.start();
		pro2.start();
		con1.start();
		con2.start();
	}

}
