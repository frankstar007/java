/**
 * 
 */
package com.frankstar;

import java.util.LinkedList;

/**
 * @author frankstar
 * @function 宽度优先的队列
 *  自定义队列类 保存TODO 表
 */
public class Queue {
	//定义一个队列，使用LinkedList实现
	private LinkedList<Object> queue = new LinkedList<Object>();
	//将t加入队列
	public void enQueue (Object t) {
		queue.addLast(t);
	}
	//取出第一项并将其返回
	public Object deQueue () {
		return queue.removeFirst();
	}
	//返回队列是否为空
	public boolean isEmptyQueue() {
		return queue.isEmpty();
	}
	//判断队列中是否含有t
	public Object contians(Object t) {
		return queue.contains(t);
	}
	
}
