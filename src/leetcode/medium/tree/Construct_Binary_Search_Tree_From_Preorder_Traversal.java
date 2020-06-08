package leetcode.medium.tree;

import leetcode.TreeNode.TreeNode;

/**
 * 1008. Construct Binary Search Tree from Preorder Traversal
 * @author mgpc
 */
public class Construct_Binary_Search_Tree_From_Preorder_Traversal {
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] preorder = {8, 5, 1, 7, 10, 12};
		TreeNode root = sol.bstFromPreorder(preorder);
	}
}


class Solution {
    int i =0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, Integer.MAX_VALUE);
    }
    
    public TreeNode bst(int[] preorder, int bound) {
        if(i == preorder.length || preorder[i] > bound) return null;
        
        TreeNode node = new TreeNode(preorder[i++]);
        node.left = bst(preorder, node.val);
        node.right = bst(preorder, bound);
        return node;
    }
}