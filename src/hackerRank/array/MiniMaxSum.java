package hackerRank.array;

/**
 * Difiiculty : Easy
 */
public class MiniMaxSum {
	public static void main(String[] args) {
		int[] nums = new int[]{
				254961783, 604179258, 462517083, 967304281, 860273491
		};
		Solution.miniMaxSum(nums);
	}

	static class Solution {
		static void miniMaxSum(int[] arr) {
	        long sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	        
	        for(int n : arr) {
	        	Long l = Long.valueOf(String.valueOf(n));
	            min = Math.min(min, l);
	            max = Math.max(max, l);
	            sum+=l;
	        }
	        System.out.println((sum - max) + " " + (sum - min));
	    }
	}
}
