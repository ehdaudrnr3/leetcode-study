package leetcode.array;

/**
 * Difiiculty : Medium
 */
public class Longest_subarray_of_1s_after_deleting_one_element {
	public static void main(String[] args) {
		int[] nums = new int[]{ 0,1,1,1,0,1,1,0,1};
		int answer = Solution.longestSubarray(nums);
		System.out.println(answer);
	}

	static class Solution {
	    public static int longestSubarray(int[] nums) {
	        int answer = 0;
	        int prev = 0, count =0;
	        for (int num : nums) {
				if(num == 1) {
					count++;
				} else {
					answer = Math.max(answer, prev + count);
					prev = count;
					count = 0;
				}
			}
	        answer = Math.max(answer, prev + count);
	        return nums.length == answer ? answer - 1 : answer;
	    }
	}
}
