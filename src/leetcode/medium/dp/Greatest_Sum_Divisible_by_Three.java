package leetcode.medium.dp;

import java.util.Arrays;

public class Greatest_Sum_Divisible_by_Three {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {3, 6, 5, 1, 8};
		int answer = sol.maxSumDivThree(nums );
		System.out.println("answer : " + answer);
	}
	
	static class Solution {
	    public int maxSumDivThree(int[] nums) {
	        int[] dp = new int[3];
	        for (int num : nums) {
				int[] tmp = Arrays.copyOf(dp, dp.length);
				for (int i : tmp) {
					dp[(num + i) % 3] = Math.max(dp[(num+i) % 3], i + num);
				}
			}
	        return dp[0];
	    }
	}
}
