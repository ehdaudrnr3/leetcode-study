package leetcode.easy.dfs;

import java.util.List;

public class Maximum_Depth_of_N_ary_Tree {

	static class Solution {
	    public int maxDepth(Node root) {
	        if(root == null) return 0;
	        
	        int max = 0;
	        for(Node n : root.children) {
	            max = Math.max(maxDepth(n), max);
	        }
	        return max+1;
	    }
	}
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
}
