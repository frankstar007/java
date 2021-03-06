/**
 * 
 */
package com.frankstar.javaExam;

import java.io.Serializable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ArrayBlockingQueue;
/**
 * @author frankstar
 * @fuction 测试线程池
 */
class ThreadPoolTask implements Runnable, Serializable {
	private static final long serialVersionUID = 1l;
	
	private static int consumerTaskSleepTime = 2000;
	private String threadPoolTaskData;
	public ThreadPoolTask(String tasks) {
		this.threadPoolTaskData = tasks;
	}
	public void run() {
		System.out.println("start .." + threadPoolTaskData);
		try {
			 Thread.sleep(consumerTaskSleepTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		threadPoolTaskData = null;
		
	}
}
public class TestThreadPool {

	private static int produceTaskSleepTime = 2000;
	
	
	public static void main(String[] args) {
		//构造一个线程池
		ThreadPoolExecutor producerPoll = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, 
				new ArrayBlockingQueue(3),
				new ThreadPoolExecutor.DiscardOldestPolicy());
		//每隔produceTaskSleepTime的时间向线程池派送一个任务
		int i = 1;
		while (true) {
			try {
				Thread.sleep(produceTaskSleepTime);
				String task = "task@" + i;
				System.out.println("put " + task);
				//用execut方法启动一个线程
				producerPoll.execute(new ThreadPoolTask(task));
				i++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
