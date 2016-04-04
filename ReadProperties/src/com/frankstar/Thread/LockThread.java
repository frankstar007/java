/**
 * 
 */
package com.frankstar.Thread;

/**
 * @author frankstar
 * 线程死锁问题
 */
public class LockThread implements Runnable {
	public int flag = 1;
	static Object o1 = new Object(), o2 = new Object();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LockThread lt1 = new LockThread();
		LockThread lt2 = new LockThread();
		
		lt1.flag = 1;
		lt2.flag = 0;
		
		Thread t1 = new Thread(lt1);
		Thread t2 = new Thread(lt2);
		
		t1.setName("frank");
		t2.setName("star");
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " flag = " + flag);
//		这里的两个if语句都将无法执行，因为已经造成了线程死锁的问题 
//		flag=1这个线程在等待flag=0这个线程把对象o2的锁解开， 
//		而flag=0这个线程也在等待flag=1这个线程把对象o1的锁解开 
//		然而这两个线程都不愿意解开锁住的对象，所以就造成了线程死锁的问题
		if (flag == 1) {
			synchronized (o1) { //锁定o1对象 只有o1这个线程对象执行完毕才会释放锁
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(o2) {
//					前面已经锁住了对象o1，只要再能锁住o2，那么就能执行打印出1的操作了 
//					可是这里无法锁定对象o2，因为在另外一个flag=0这个线程里面已经把对象o1给锁住了 
//					尽管锁住o2这个对象的线程会每隔500毫秒睡眠一次，可是在睡眠的时候仍然是锁住o2不放的
					System.out.println("1");
				}
			}
			
		}
		if (flag == 0) {
			synchronized (o2) { //锁定o2对象 只有o2这个线程对象执行完毕才会释放锁
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(o1) {
//					前面已经锁住了对象o1，只要再能锁住o2，那么就能执行打印出1的操作了 
//					可是这里无法锁定对象o2，因为在另外一个flag=0这个线程里面已经把对象o1给锁住了 
//					尽管锁住o2这个对象的线程会每隔500毫秒睡眠一次，可是在睡眠的时候仍然是锁住o2不放的
					System.out.println("1");
				}
			}
			
		}
	
	}

}
