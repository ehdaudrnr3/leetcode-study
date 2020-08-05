package dataStructure.bst;

import leetcode.TreeNode.TreeNode;

public class BstSearch {
	public static void main(String[] args) {
		
		TreeNode root = createTree();
		TreeNode recursionSearch = recursionSearch(root, 2);
		if(recursionSearch != null) {
			System.out.println("Recursive find : "+recursionSearch.val);
		} else {
			System.out.println("Recursive not found ");
		}

		TreeNode iterSearch = iterSearch(root, 10);
		if(iterSearch != null) {
			System.out.println("Iterator Find : "+iterSearch.val);
		} else {
			System.out.println("Iterrator not found ");
		}
		
	}
	
	public static TreeNode createTree() {
		
		/**
		 *            3
		 *         /     \
		 *       1         5
		 *     /   \     /   \
		 *    0     2   4     6
		 */
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(6);
		
		return root;
	}
	
	public static TreeNode recursionSearch(TreeNode node, int findValue) {
		if(node == null || node.val == findValue) {
			return node;
		} 
		if(findValue < node.val) {
			return recursionSearch(node.left, findValue);
		} else {
			return recursionSearch(node.right, findValue);
		}
	}
	
	public static TreeNode iterSearch(TreeNode node, int findValue) {
		while(node != null && node.val != findValue) {
			if(findValue < node.val) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return node;
	}
}
