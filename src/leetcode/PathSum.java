package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
	static List<List<Integer>> result = new ArrayList<>();

	public static void main(String[] args) {
		TreeNode four = new TreeNode(4);
		TreeNode right = new TreeNode(8);
		TreeNode root = new TreeNode(5);
		root.left = four;
		root.right = right;
		
		pathSum(root, 9);
	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
    
        dfs(root, sum, list);
        return result;
    }
	
	public static void dfs(TreeNode root, int sum, List<Integer> list) {
		if (root == null) {
			return;
		}

		list.add(root.val);
		if (root.left == null && root.right == null && sum - root.val == 0) {
			result.add(new ArrayList<>(list));
			list.remove(list.size() - 1);
			return;
		}
		System.out.println(list);
		dfs(root.left, sum - root.val, list);
		dfs(root.right, sum - root.val, list);

		list.remove(list.size() - 1);
	}
	
	 static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
		 
}
