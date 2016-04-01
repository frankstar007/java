/**
 * 
 */
package com.frankstar.Thread;

/**
 * @author frankstar
 * 实现接口Runnable
 *
 */
public class RunnableImplement implements Runnable {
	private String name;
	
	public RunnableImplement(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 5; i++) {
			System.out.println(this.getName() + ":" + i);
		}
		
	}
	

}
