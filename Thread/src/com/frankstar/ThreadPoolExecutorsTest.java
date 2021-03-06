/**
 * 
 */
package com.frankstar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author frankstar
 * @function newCachedThreadPool 创建一个可缓存的线程池
 */
public class ThreadPoolExecutorsTest {
	public void cachedThreadTest() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = 1;
			try {
				Thread.sleep(index * 1000);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(index);
				}
			});
		}
	}
	
	public void fixedThreadTest() {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index = 1;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	public void scheduledThreadTest() {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			public void run() {
				//表示延迟1秒后每3秒执行一次
				System.out.println("delay 1 second, and execute every 3 seconds");
			}
		}, 1, 3, TimeUnit.SECONDS);
	}
	
	public void singledThreadTest() {
		ExecutorService singledThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int index = 1;
			singledThreadExecutor.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}


	public static void main(String[] args) {
		ThreadPoolExecutorsTest tpet = new ThreadPoolExecutorsTest();
		//tpet.fixedThreadTest();
		//tpet.scheduledThreadTest();
		tpet.singledThreadTest();
		
	}
}
