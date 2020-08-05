package dataStructure.bst;

import leetcode.TreeNode.TreeNode;

public class Successor {
	
	public static void main(String[] args) {
		TreeNode root = createTree();
		
		TreeNode findNode15 = search(root, 15);
		TreeNode successor15 = successor(findNode15);
		TreeNode preSuccessor15 = preSuccessor(findNode15);
		System.out.println(findNode15.val+"의 successor는 "+successor15.val);
		System.out.println(findNode15.val+"의 preSuccessor는 "+preSuccessor15.val);
		
		TreeNode findNode6 = search(root, 6);
		TreeNode successor6 = successor(findNode6);
		TreeNode preSuccessor6 = preSuccessor(findNode6);
		System.out.println(findNode6.val+"의 successor는 "+successor6.val);
		System.out.println(findNode6.val+"의 preSuccessor는 "+preSuccessor6.val);
		
		TreeNode findNode4 = search(root, 4);
		TreeNode successor4 = successor(findNode4);
		TreeNode preSuccessor4 = preSuccessor(findNode4);
		System.out.println(findNode4.val+"의 successor는 "+successor4.val);
		System.out.println(findNode4.val+"의 preSuccessor는 "+preSuccessor4.val);
	}
	
	/**
	 * Key[x]보다 크면서 가장 작은키를 가진 노드
	 * 시간복잡도 O(h)
	 * @author mgpc
	 *
	 */
	public static TreeNode successor(TreeNode node) {
		if(node.right != null) {
			return minimum(node.right);
		} else {
			TreeNode parent = node.parent;
			while(parent != null && node == parent.right) {
				node = parent;
				parent = parent.parent;
			}
			return parent;
		}
	}
	
	/**
	 * Key[x]보다 작으면서 가장 큰 키를 가진 노드
	 * @param node
	 * @return
	 */
	public static TreeNode preSuccessor(TreeNode node) {
		if(node.left != null) {
			return maximum(node.left);
		} else {
			TreeNode parent = node.parent;
			while(parent != null && node == parent.left) {
				node = parent;
				parent = parent.parent;
			}
			return parent;
		}
	}
	
	public static TreeNode minimum(TreeNode node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public static TreeNode maximum(TreeNode node) {
		while(node.right != null) {
			node = node.right;
		}
		return node;
	}
	
	public static TreeNode search(TreeNode node, int findValue) {
		if(node == null || node.val == findValue) {
			return node;
		}
		if(findValue < node.val) {
			return search(node.left, findValue);
		} else {
			return search(node.right, findValue);
		}
		
	}
	public static TreeNode createTree() {
		
		/**
		 *             15
		 *         /        \ 
		 *       6            18
		 *     /   \         /    \
		 *    3     7       17     20
		 *   /  \     \
		 *  2    4     13
		 *       	  /
		 *       	 9 
		 */
		
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(6, root);
		root.left.left = new TreeNode(3, root.left);
		root.left.left.left = new TreeNode(2, root.left.left);
		root.left.left.right = new TreeNode(4, root.left.left);
		root.left.right = new TreeNode(7, root.left);
		root.left.right.right = new TreeNode(13, root.left.right);
		root.left.right.right.left = new TreeNode(9, root.left.right.right);

		root.right = new TreeNode(18, root);
		root.right.left = new TreeNode(17, root.right);
		root.right.right = new TreeNode(20, root.right);
		
		return root;
	}
}
