package leetcode;

public class MinStack {
	
	
	public static void main(String[] args) {
		Stack minStack = new Stack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
}

class Stack {
	private Node head;
	
	public void push(int x) {
		if(head == null) {
			head = new Node(x, x);
		} else {
			Node newNode = new Node(x, Math.min(head.min, x),head);
			head = newNode;
		}
	}
	
	public void pop() {
		head = head.next;
	}
	
	public int top() {
		return head.value;
	}
	
	public int getMin() {
		return head.min;
	}
	
	private class Node {
		int value;
		int min;
		Node next;
		
		public Node(int value, int min) {
			this.value = value;
			this.min = min;
		}

		public Node(int value, int min, Node next) {
			this.value = value;
			this.min = min;
			this.next = next;
		}
	}
}
