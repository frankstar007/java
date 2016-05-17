package com.frankstar.letCode1_5;

class ListNode {
	int val;
	ListNode next;
	public ListNode(int x) {
		val = x;
	}
}

public class AddTwoNumbers {
	@SuppressWarnings("null")
	public ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
		ListNode result = new ListNode(0);
		ListNode p = null;
		ListNode q = null;
		p = listNode1;
		q = listNode2;
		ListNode node = result;
		while (p != null || q != null) {
			int val = p.val + q.val;
			int head = val / 10;
			int tail = val % 10;
			node.next = new ListNode(tail);
			node = node.next;
			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}
			if (head > 0) {
				node.next = new ListNode(head);
			}
			
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
