package dataStructure.bst;

import leetcode.TreeNode.TreeNode;

public class BstDelete {
	public static void main(String[] args) {
		
		TreeNode node = createTree();
		TreeNode delete = delete(node, 6);
		System.out.println(delete.val);
	}
	
	/**
	 * case 1: �ڽĳ�尡 ���°�� => �׳ɻ���
	 * case 2: �ڽĳ�尡 1���� ��� => �ڽĳ��� �θ��带 ����
	 * case 3: �ڽĳ�尡 2���� ��� => successor�� ã�� ���� �ٲ�ġ�� �� �� 
	 * 		   successor�� �ڽ��� 0�̰ų� 1���̹Ƿ�(successor�� ������庸�� ũ�鼭 �������� ���� �������Ƿ�)
	 *         successor�� �θ�� successor�� �ڽ��� ����
	 * @param node
	 * @return
	 */
	public static TreeNode delete(TreeNode node, int value) {
		TreeNode z = search(node, value);
		TreeNode y = z;
		if(z.left != null && z.right != null) {
			y = successor(z);
		}
		
		TreeNode x=null;
		if(y.left != null) x=y.left;
		else x = y.right;
		
		if(x!= null) x.parent = y.parent;
		if(y.parent == null) {
			y = x;
		} else if(y == y.parent.left) {
			y.parent.left = x;
		} else {
			y.parent.right = x;
		}
		
		if(y != z) z.val = y.val;
		return y;
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
	
	/**
	 * Key[x]���� ũ�鼭 ���� ����Ű�� ���� ���
	 * �ð����⵵ O(h)
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
	
	public static TreeNode minimum(TreeNode node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public static TreeNode createTree() {
		
		/**
		 *             13
		 *         /        \ 
		 *       6            18
		 *     /   \         /    \
		 *    3     7       17     20
		 *   /  \          /
		 *  2    4        15
		 *       	        \
		 *       	         16  
		 */
		
		TreeNode root = new TreeNode(13);
		root.left = new TreeNode(6, root);
		root.left.left = new TreeNode(3, root.left);
		root.left.right = new TreeNode(7, root.left);
		root.left.left.left = new TreeNode(2, root.left.left);
		root.left.left.right = new TreeNode(4, root.left.left);

		root.right = new TreeNode(18, root);
		root.right.left = new TreeNode(17, root.right);
		root.right.right = new TreeNode(20, root.right);
		root.right.left.left = new TreeNode(15, root.right.left);
		root.right.left.left.right = new TreeNode(16, root.right.left.left);
		
		return root;
	}
}
