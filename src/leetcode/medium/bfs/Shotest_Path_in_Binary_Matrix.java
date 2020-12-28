package leetcode.medium.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Shotest_Path_in_Binary_Matrix {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[][] testCase1 = { 
			{0, 1},
			{1, 0}
		};
		int[][] testCase2 = { 
			{0, 0, 0},
			{1, 1, 0},
			{1, 1, 0}
		};
		
		int[][] testCase3 = { 
			{1, 0, 0},
			{1, 1, 0},
			{1, 1, 0}
		};
		
		int answer = sol.shortestPathBinaryMatrix(testCase3);
		System.out.println("answer : "+ answer);
	}
	
	static class Solution {
		
		private final int[][] dirs = {
			{0, -1}, {1, -1}, {1, 0}, {1, 1},
			{0, 1}, {-1, 1}, {-1, 0}, {-1, -1}
		};
		
	    public int shortestPathBinaryMatrix(int[][] grid) {
	    	if(grid[0][0] == 1) {
	    		return -1;
	    	}
	        int m = grid.length;
	        int n = grid[0].length;
	        boolean[][] visited = new boolean[m][n];
	        Queue<int[]> queue = new LinkedList<>();
	        queue.offer(new int[] {0, 0});
	        visited[0][0] = true;
	        
	        int minPath = 0;
	        while(!queue.isEmpty()) {
	        	int size = queue.size();
	        	minPath++;
	        	for(int i = 0; i < size; i++) {
	        		int[] curr = queue.poll();
	        		if(curr[0] == m - 1 && curr[1] == n - 1) {
	        			return minPath;
	        		}
	        		for (int[] dir : dirs) {
						int x = curr[0] + dir[0];
						int y = curr[1] + dir[1];
						
						if(avaliable(x, y, grid, visited)) {
							visited[x][y] = true;
							queue.offer(new int[] { x, y });
						}
					}
	        	}
	        }
	        return -1;
	    }
	    
	    public boolean avaliable(int x, int y, int[][] grid, boolean[][] visited) {
	    	int m = grid.length;
	    	int n = grid[0].length;
	    	if(x < m && y < n && x >= 0 && y >= 0 && grid[x][y] != 1 && visited[x][y] == false) {
	    		return true;
	    	}
	    	return false;
	    }
	}
}
