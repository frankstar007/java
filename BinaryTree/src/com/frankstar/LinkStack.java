/**
 * 
 */
package com.frankstar;

/**
 * @author frankstar
 * 栈的链式存储结构
 */
public class LinkStack<T> {
	//定义节点数据结构
	private class Node {
		public T data;
		public Node next;
		
		//无参数
		public Node() {}
		//参数
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	//栈顶元素
	private Node top;
	//元素个数
	private int size;
	//入栈
	public void insert(T element) {
		top = new Node(element, top);
		size++;	
	}
	//出栈
	public T pop() {
			Node temp = top;
			top = top.next;
			temp.next = null;
			size--;
			return temp.data;
	
	}
	//返回栈顶元素 但是不出栈
	public T peek() {
		return top.data;
	}
	//栈的长度
	public int size() {
		return size;
	}
	//栈是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	public String toString() {
		if (isEmpty()) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (Node current = top; current != null; current = current.next) {
				sb.append(current.data.toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
		}
	}
	
	public static void main(String[] args) {
		LinkStack<String> stack = new LinkStack<String>();
		stack.insert("A");
		stack.insert("B");
		stack.insert("C");
		stack.insert("D");
		
		System.out.println(stack);
		
		System.out.println("栈顶元素： " + stack.peek());
		
		System.out.println("pop num1 :" + stack.pop());
		System.out.println("pop num2 :" + stack.pop());
		
		System.out.println(stack);
	}
	
}
