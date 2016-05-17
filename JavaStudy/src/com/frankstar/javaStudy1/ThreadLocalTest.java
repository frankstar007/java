/**
 * 
 */
package com.frankstar.javaStudy1;

/**
 * @author frankstar
 * ThreadLocal是一个容器，向这个容器存储对象，在当前线程范围内都可以取得出来，向ThreadLocal里面存东西
 * 就是向它里面的MAP存东西，然后ThreadLocal把这个map挂到当前线程底下，这个map就属于这个线程了
 */
public class ThreadLocalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread);
		ThreadLocal<String> threadLocal  = new ThreadLocal<String>();
		//把某个对象绑定到当前线程上，对象以键值对的形式存储到一个map中
		//key是当前线程，map(currentThread,"frankstar")
		threadLocal.set("frankstar");
		String value = threadLocal.get();
		System.out.println(value);
	}

}
