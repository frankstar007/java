package com.frankstar;

//链式队列
public class LinkQueue<T> {
	//链的数据接口
	private class Node {
		public T data;
		public Node next;
		
		public Node(){}
		
		public Node(T data, Node node) {
			this.data = data;
			this.next = node;
		}	
	}
	//头指针
	private Node front;
	//尾指针
	private Node rear;
	private int size;
	public LinkQueue() {
		Node node = new Node(null, null);
		node.next = null;
		front = rear = node;
	}
	//队列入栈
	public void enQueue (T data) {
		//创建一个节点
		Node temp = new Node(data, null);
		rear.next = temp;
		rear = temp;
		size++;
	}
	//出队
	public T deQueue() {
		if (rear == front) {
			try {
				throw new Exception("empty!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		} else {
			Node temp = front.next;
			T data = temp.data;
			front.next = temp.next;
			if (temp.next == null) {
				rear = front;
			}
			temp = null;
			size--;
			return data;
		}
	}
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		if (isEmpty()) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for(Node current = front.next; current != null; current = current.next) {
				sb.append(current.data.toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len -2, len).append("]").toString();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkQueue<Integer> queue=new LinkQueue<Integer>();  
        queue.enQueue(1);  
        queue.enQueue(2);  
        queue.enQueue(3);  
        queue.enQueue(4);  
        queue.enQueue(5);  
        queue.enQueue(6);  
        System.out.println(queue);  
        System.out.println("出队："+queue.deQueue());  
        System.out.println("队列长度="+queue.size());  
        System.out.println(queue);  
        System.out.println("出队："+queue.deQueue());  
        System.out.println("队列长度="+queue.size());  
        System.out.println(queue);  
        System.out.println("出队："+queue.deQueue());  
        System.out.println("队列长度="+queue.size());  
        System.out.println(queue);
	}

}