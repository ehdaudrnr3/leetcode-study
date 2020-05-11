package leetcode;

public class MinimumPath {
	static int[][] m;
	static int[][] l;
	static char[][] p;
	
	public static void main(String[] args) {
		m = new int[][]{
			{6, 7, 12, 5},
			{5, 3, 11, 18},
			{7, 17, 3, 3},
			{8, 10, 14, 9}
		};
		
		l = new int[][]{
			{-1, -1, -1, -1},
			{-1, -1, -1, -1},
			{-1, -1, -1, -1},
			{-1, -1, -1, -1}
		};
		
		p = new char[l.length][l[0].length];
		
		System.out.println(recursionMin(3, 3));
		System.out.println(memoization(3, 3));
		System.out.println(bottomUp(3, 3));
		printPath();
	}
	
	public static int recursionMin(int i, int j) {
		if(i == 0 && j == 0) {
			return m[i][j];
		} else if(i == 0) {
			return recursionMin(i, j-1) + m[i][j];
		} else if(j == 0) {
			return recursionMin(i-1, j) + m[i][j];
		} else {
			return Math.min(recursionMin(i-1, j), recursionMin(i, j-1)) + m[i][j];
		}
	}
	
	public static int memoization(int i, int j) {
		if(l[i][j] != -1) return l[i][j];
		
		if(i == 0 && j == 0) {
			l[i][j] = m[i][j];
		} else if(i == 0) {
			l[i][j] = memoization(i, j-1) + m[i][j];
		} else if(j == 0) {
			l[i][j] = memoization(i-1, j) + m[i][j];
		} else {
			l[i][j] = Math.min(memoization(i-1, j), memoization(i, j-1)) + m[i][j];
		}
		return l[i][j];
	}
	
	public static int bottomUp(int k, int n) {
		for (int i = 0; i <= k; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == 0 && j == 0) {
					l[i][j] = m[i][j];
					p[i][j] = '-';
				} else if(i == 0) {
					l[i][j] = l[i][j-1] + m[i][j];
					p[i][j] = 'ก็';
				} else if(j == 0) {
					l[i][j] = l[i-1][j] + m[i][j];
					p[i][j] = 'ก่';
				} else {
					if(l[i-1][j] < l[i][j-1]) {
						p[i][j] = 'ก่';
					} else {
						p[i][j] = 'ก็';
					}
					l[i][j] = Math.min(l[i-1][j], l[i][j-1]) + m[i][j];
				}
			}
		}
		return l[k][n];
	}
	
	public static void printPath() {
		int i = p.length-1, j = p[0].length-1;
		while(p[i][j] != '-') {
			System.out.println(i+" "+j);
			if(p[i][j] == 'ก็') {
				j = j-1;
			} else {
				i = i-1;
			}
		}
		
		System.out.println(i+" "+j);
	}
}
