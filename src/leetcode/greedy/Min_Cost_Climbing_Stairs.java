package leetcode.greedy;

public class Min_Cost_Climbing_Stairs {

	public static void main(String[] args) {
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		int answer = Solution.minCostClimbingStairs(cost);
		System.out.println("Answer : " + answer);
	}
	
	static class Solution {
	    public static int minCostClimbingStairs(int[] cost) {
	    	int n = cost.length;
	        /* Bottom Up dp*/
	    	//return dynamic(cost);
	    	
	    	/* recursion */
//	    	return Math.min(recursion(cost, n-1), recursion(cost, n-2));
	    	
	    	/* recusion memoization*/ 
//	    	 int[] dp = new int[cost.length];
//	    	 return Math.min(recursionWithMemoization(dp, cost, n-2), recursionWithMemoization(dp, cost, n-1));
	    	
	    	/* bottom up dp */
	    	//return bottomUpDp(cost);
	    	
	    	/* fine tuning */
	    	return fineTuning(cost);
	    }
	    
	    private static int dynamic(int[] cost) {
	    	if(cost.length == 0) return 0;
	        if(cost.length == 1) return cost[0];
	        for(int i = 2; i < cost.length; i++) {
	            cost[i] += Math.min(cost[i-2], cost[i-1]);
	        }
	        return Math.min(cost[cost.length-2], cost[cost.length-1]);
	    }
	    
	    private static int recursion(int[] cost, int n) {
	    	if(n < 0) return 0;
	    	if(n == 0 || n == 1) return cost[n];
	    	return cost[n] + Math.min(recursion(cost, n-2), recursion(cost, n - 1));
	    }
	    
	    private static int recursionWithMemoization(int[] dp, int[] cost, int n) {
	    	if(n < 0) return 0;
	    	if(n == 0 || n == 1) return cost[n];
	    	if(dp[n] != 0) return dp[n];
	    	return cost[n] + Math.min(recursion(cost, n-2), recursion(cost, n - 1));
	    }
	    
	    private static int bottomUpDp(int[] cost) {
	    	int n = cost.length;
	    	int[] dp = new int[n];
	    	
	    	for (int i = 0; i < cost.length; i++) {
	    		if(i < 2) dp[i] = cost[i];
	    		else dp[i] = cost[i] + Math.min(dp[i-2], dp[i-1]); 
			}
	    	return Math.min(dp[n-2], dp[n-1]);
	    }
	    
	    private static int fineTuning(int[] cost) {
	    	int n = cost.length;
	    	int first = cost[0];
	    	int second = cost[1];
	    	
	    	if(n<=2) return Math.min(first, second);
	    	for(int i = 2; i < n; i++) {
	    		int curr = cost[i] + Math.min(first, second);
	    		first = second;
	    		second = curr;
	    	}
	    	return Math.min(first, second);
	    }
	}
}
