package leetcode;

public class ClimbStairs {
	public static void main(String[] args) {
		int stairs = climbStairs(5);
		System.out.println(stairs);
	}
	
	public static int climbStairs(int n) {
		if(n == 1) 
			return 1;
		if(n == 2)
			return 2;
		
		int prev = 1;
		int pprev = 2;
		for(int i=2;i<n;i++) {
			int next = pprev;
			pprev += prev;
			prev = next;
		}
		
		return pprev;
	}
}
