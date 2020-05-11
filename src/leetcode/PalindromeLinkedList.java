package leetcode;

import java.util.Stack;

public class PalindromeLinkedList {
	static ListNode recursion;
	
	public static void main(String[] args) {
		ListNode head = null;
		ListNode node = new ListNode(1);
		ListNode n = new ListNode(2);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(1);
		
		n2.next = n3;
		n.next = n2;
		node.next = n;
		head = node;
		
		recursion = head;
		System.out.println(isPalindromeByRecursion(head));
	}

	public static boolean isPalindromeByStack(ListNode head) {
		ListNode tail = head;
		Stack<Integer> st = new Stack<Integer>();
		while(tail != null) {
			st.add(tail.val);
			tail = tail.next;
		}
		
		while(!st.isEmpty()) {
			if(head.val != st.pop()) {
				return false;
			}
			head = head.next;
		}
		
		return true;
	}
	
	public static boolean isPalindromeByRecursion(ListNode head) {
		if(head == null) return true;
		if(isPalindromeByRecursion(head.next) && recursion.val == head.val) {
			recursion = recursion.next;
			return true;
		}
		
		return false;
	}
	
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
