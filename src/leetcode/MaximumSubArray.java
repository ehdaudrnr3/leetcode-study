package leetcode;
import java.util.Arrays;

public class MaximumSubArray {
	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int max = maxSubArray(nums);
		System.out.println("Answer : " + max);
	}

	public static int maxSubArray(int[] nums) {
		int[] dictionary = new int[nums.length];
		dictionary[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int dic = dictionary[i-1]+nums[i];
			dictionary[i] = Math.max(dic, nums[i]);
		}
		return Arrays.stream(dictionary).max().getAsInt();
	}
}
