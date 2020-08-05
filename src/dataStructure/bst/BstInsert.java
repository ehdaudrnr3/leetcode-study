package dataStructure.bst;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.TreeNode.TreeNode;

public class BstInsert {
	
	public static void main(String[] args) {
		
		Bst bst = new Bst();
		bst.insert(30);
		bst.insert(20);
		bst.insert(25);
		bst.insert(40);
		bst.insert(10);
		bst.insert(35);
		
		bst.print();
	}
	
}

class Bst {
	TreeNode head;
	
	public void insert(int value) {
		TreeNode parent = null;
		TreeNode node = head;
		
		while(node != null) {
			parent = node;
			if(value < node.val) {
				node = node.left; 
			} else {
				node = node.right;
			}
		}
		
		if(parent == null) {
			head = new TreeNode(value);
		} else if(value < parent.val) {
			parent.left = new TreeNode(value);
		} else {
			parent.right = new TreeNode(value);
		}
	}
	
	public void print() {
		TreeNode node = head;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		while(!q.isEmpty()) {
			TreeNode poll = q.poll();
			System.out.println(poll.val);
			if(poll.left != null) {
				q.offer(poll.left);
			}
			if(poll.right != null) {
				q.offer(poll.right);
			}
		}
	}
}