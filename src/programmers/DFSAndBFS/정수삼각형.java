package programmers.DFSAndBFS;

public class Á¤¼ö»ï°¢Çü {

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		int answer = Solution.solution(triangle);
		System.out.println("answer : " + answer);
	}
	
	static class Solution {
		private static int dic[][];
	    public static int solution(int[][] triangle) {
	    	dic = new int[triangle.length][triangle.length];
	        int answer = max(0, 0, triangle);
	        return answer;
	    }
	    
	    public static int max(int row, int col, int[][] triangle) {
	    	if(row == triangle.length || col == triangle.length) {
	    		return 0;
	    	} else if(dic[row][col] != 0) {
	    		return dic[row][col];
	    	}
	    	
	    	int left = max(row+1, col, triangle);
	    	int right = max(row+1, col+1, triangle);
	    	return dic[row][col] = triangle[row][col] + Math.max(left, right);
	    }
	}
}
