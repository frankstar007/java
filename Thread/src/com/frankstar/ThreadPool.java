/**
 * 
 */
package com.frankstar;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author frankstar
 * 线程池的学习
 */
class MyTask implements Runnable {
	private int taskNum;
	
	public MyTask(int num) {
		this.taskNum = num;
	}
	@Override
	public void run() {
		System.out.println("正在执行task " + taskNum);
		try {
			Thread.currentThread().sleep(4000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task " + taskNum + "执行完毕！");
		
	}
	
}
public class ThreadPool {
	
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5));
		
		for(int i = 1; i < 15; i++) {
			MyTask mt = new MyTask(i);
			executor.execute(mt);
			System.out.println("线程池中线程数目：" + executor.getPoolSize() + " 队列中等待执行的任务数目：" +
			executor.getQueue().size() + " 已执行完别的任务数目：" + executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}

}
