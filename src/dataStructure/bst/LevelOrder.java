package dataStructure.bst;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.TreeNode.TreeNode;

public class LevelOrder {
	
	public static void main(String[] args) {
		
		TreeNode root = createTree();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		
		System.out.print("방문순서 : ");
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			
			if(node.left != null) {
				q.offer(node.left);
			} 
			if(node.right != null) {
				q.offer(node.right);
			}
			
			if(!q.isEmpty()) {
				System.out.print(node.val+", ");
			} else {
				System.out.print(node.val);
			}
		}
	}
	
	public static TreeNode createTree() {
		
		/**
		 *            3
		 *         /     \
		 *       1         5
		 *     /   \     /   \
		 *    0     2   4     6
		 *        /   \
		 *       7     8 
		 */
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(6);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(8);
		
		return root;
	}
}


