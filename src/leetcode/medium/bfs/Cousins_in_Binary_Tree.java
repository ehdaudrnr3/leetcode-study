package leetcode.medium.bfs;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.TreeNode.TreeNode;

public class Cousins_in_Binary_Tree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(5);
		
		Solution sol = new Solution();
		boolean isCousion = sol.isCousionsBfs(root, 5, 4);
		System.out.println(isCousion);
	}
}

class Solution {
	TreeNode xP = null, yP=null;
	int xDepth = 0, yDepth = 0;
	
	public boolean isCousionsDfs(TreeNode root, int x, int y) {
		dfs(root, null, x, y, 0);
		return xDepth == yDepth && xP != yP;
	}
	
	public boolean isCousionsBfs(TreeNode root, int x, int y) {
		return bfs(root, x, y);
	}
	
	public void dfs(TreeNode node, TreeNode parent, int x, int y, int depth) {
		if(node == null) return;
		
		if(node.val == x) {
			xDepth = depth;
			xP = parent;
		} else if(node.val == y) {
			yDepth = depth;
			yP = parent;
		}
		
		dfs(node.left, node, x, y, depth+1);
		dfs(node.right, node, x, y, depth+1);
	}
	
	public boolean bfs(TreeNode root, int x, int y) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		int depth = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			while(size > 0) {
				TreeNode node = q.poll();
				if(node.left != null) {
					q.add(node.left);
				}
				if(node.right != null) {
					q.add(node.right);
				}
				
				if(node.left != null && node.right != null) {
					if(node.left.val == x && node.right.val == y) {
						return false;
					} else if(node.left.val == y && node.right.val == x) {
						return false;
					}
				}
				
				if(node.val == x) {
					xDepth = depth;
				} else if(node.val == y) {
					yDepth = depth;
				}
				size--;
			}
			depth++;
		}
		
		return xDepth == yDepth;
		
	}
}
