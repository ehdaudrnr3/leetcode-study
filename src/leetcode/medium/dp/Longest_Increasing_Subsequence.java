package leetcode.medium.dp;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {
	
	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(nums));
	}

	public static int lengthOfLIS(int[] nums) {
		if(nums.length == 0) return 0;
		else if(nums.length == 1) return 1;
		
		int max = Integer.MAX_VALUE;
		int[] dp = new int[nums.length];
		Arrays.fill(dp, max);
		
		for (int i = 0; i < nums.length; i++) {
			dp[position(dp, i, nums[i])] = nums[i];
		}
		
		for (int j = dp.length - 1; j >= 0; j--) {
			if(dp[j] != max) return j+1;
		}
		return 0;
	}
	
	public static int position(int[] dp, int right, int target) {
		int left = 0;
		
		while(left <= right) {
			int mid = left + ((right - left) / 2);
			
			if(dp[mid] == target) return mid;
			if(dp[mid] < target) left = mid + 1;
			else right = mid - 1;
		}
		
		return left;
	}
}
