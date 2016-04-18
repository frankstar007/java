/**
 * 
 */
package com.frankstar;

/**
 * @author frankstar
 * 循环队列
 */
public class CirQueue<E> {

	//对象数组
	E[] a;
	// 默认初始化大小
	private static final int DEFAULT_SIZE = 10;
	//队首
	int front;
	//队尾
	int rear;
	
	public CirQueue() {
		this(DEFAULT_SIZE);
	}
	@SuppressWarnings("unchecked")
	public CirQueue(int defaultSize) {
		a = (E[])(new Object[defaultSize]);
		front = 0;
		rear = 0;
	}
	/** 
     * 将一个对象追加到队列尾部 
     * @param obj 
     * @return 队列满时返回false,否则返回true 
     * @author frankstar
    **/
	public boolean enQueue(E obj) {
		if ((1 + rear)%a.length == front) {
			return false;
		} else {
			a[rear] = obj;
			rear = (rear + 1)%a.length;
			return true;
		}
	}
	//队列头部出队
	public E deQueue() {
		if (rear == front) {
			return null;
		} else {
			E obj = a[front];
			front = (front + 1)%a.length;
			return obj;
		}
	}
	//队列长度
	public int size() {
		return (rear - front)&(a.length - 1);
	}
	//队列长度2
	public int length() {
		if (rear > front) {
			return rear - front;
		} else {
			return a.length - 1;
		}
	}
	//判断是否为空
	public boolean isEmpty() {
		return rear == front;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CirQueue<String> queue=new CirQueue<String>(4);  
        queue.enQueue("1");  
        queue.enQueue("2");  
        queue.enQueue("3");  
        System.out.println("size="+queue.size());  
        int size=queue.size();  
        System.out.println("*******出栈操作*******");  
        for(int i=0; i<size;i++){  
            System.out.print(queue.deQueue()+" ");  
        }  
	}

}
