package leetcode;

public class ClimbStairs {
	public static void main(String[] args) {
		String S = "BAAABAB";
		char[] chs = S.toCharArray();
		char[] dp = new char[S.length()];
		
		if(S.length() < 3) {
			System.out.println(0);
		} 
		
		int count =0;
		for(int i = 2; i<chs.length;i++) {
			if(chs[i-2] != chs[i-1] && chs[i-1] == chs[i]) {
				count++;
			} else if(chs[i-2] != chs[i-1] && chs[i-1] != chs[i]){
				count++;
			}
		}
		System.out.println(count);
		
		
		
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
