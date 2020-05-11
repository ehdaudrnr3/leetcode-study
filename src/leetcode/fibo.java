package leetcode;

public class fibo {
	private static int[] f;
	
	public static void main(String[] args) {
		int n = 10;
		f = new int[n+2];
		System.out.println(fiboBottomUp(n));
	}
		
	public static int fibo(int n) {		//메모이제이션
		if(n==1 || n == 2) 
			return 1;
		else if(f[n] != 0) 
			return f[n];
		else {
			f[n] = fibo(n-2) + fibo(n-1);
			return f[n];
		}
	}
	
	 public static int fiboBottomUp(int n) {
		 f[1] = f[2] = 1;
		 for(int i=3;i<=n;i++) {
			 f[i] = f[i-1] + f[i-2];
		 }
		 return f[n];
	 }
}
