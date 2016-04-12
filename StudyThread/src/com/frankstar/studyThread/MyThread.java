/**
 * 
 */
package com.frankstar.studyThread;

/**
 * @author frankstar
 * @function studyThread
 *
 */
public class MyThread extends Thread{

	/**
	 * @param args
	 */
	private String name;
	
	public MyThread(String name){
		this.name = name;
	}
	public void run(){
		for(int i = 0; i < 5; i++){
			System.out.println(name + "运行： " + i);
			try{
				sleep((int)Math.random()*10);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread mt1 = new MyThread("frank");
		MyThread mt2 = new MyThread("star");
		mt1.start();
		mt2.start();
		
	}

}
