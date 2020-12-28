package leetcode.array;

/**
 * Difiiculty : Easy
 */
public class Flipping_an_image {
	public static void main(String[] args) {
		int[][] nums = new int[][]{
				{1, 1, 0},
				{1, 0, 1},
				{0, 0, 0}
		};
		int[][] answer = Solution.flipAndInvertImage(nums);
		System.out.println(answer);
	}

	static class Solution {
	    public static int[][] flipAndInvertImage(int[][] A) {
	    	 int len = A.length;
	         for(int[] d : A) {
	             int mid = len/2;
	             if(len % 2 != 0) {
	                 d[mid] ^= 1;
	             }
	             for(int i = 0; i < mid; i++) {
	                 if(d[len - i - 1] == d[i]) {
	                     d[i] = d[len - i - 1] ^= 1;
	                 }
	             }
	         }
	         return A;
	    }
	}
}
