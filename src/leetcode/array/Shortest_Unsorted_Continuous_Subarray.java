package leetcode.array;

import java.util.Arrays;

public class Shortest_Unsorted_Continuous_Subarray {
	public static void main(String[] args) {
		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		System.out.println(findUnsortedSubarray(nums));
	}

	public static int findUnsortedSubarray(int[] nums) {
        int[] copy = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
			copy[j] = nums[j];
		}
        
        Arrays.sort(copy);
        
        int l= 0, r=0;
        for (int i = 0; i < copy.length; i++) {
			if(copy[i] != nums[i]) {
				l = i;
				break;
			}
		}
        for (int i = nums.length-1; i >= 0; i--) {
			if(copy[i] != nums[i]) {
				r = i+1;
				break;
			}
		}
        
        return r-l;
    }	
}
