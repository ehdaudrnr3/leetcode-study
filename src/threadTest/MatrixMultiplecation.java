package threadTest;

public class MatrixMultiplecation {
	public static void main(String[] args) {
		Matrix matrix = new Matrix();
		matrix.general();
	}
	
	static class Matrix { 
		private int[][] a = { 
				{1, 2},
				{3, 4}
		};
		private int[][] b = {
				{1, 2},
				{3, 4}
		};
		
		public void general() {
			int p = a.length;
			int q = b[0].length;
			int r = a[0].length;
			int[][] m = new int[p][q];
			
			for(int i = 0; i < p; i++) {
				for(int j = 0; j < r; j++) {
					for(int k = 0; k < q; k++) {
						m[i][j] += a[i][k] * b[k][j]; 
					}
				}
			}
			print(m);
		}
		
		public int matrixChain(int n) {
			int p = a.length;
			int q = b[0].length;
			int r = a[0].length;
			int[][] m = new int[p][q];
			
			for(int i = 0; i < n; i++) {
				m[i][i] = 0;
			}
//			for(int r = 1; r < n - 1; r++) {
//				for(int i = 1; i <= n - r; i++) {
//					int j = i + r;
//				}
//			}
			
			return m[1][n];
		}
		
		private void print(int[][] m) {
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[0].length; j++) {
					System.out.print(m[i][j]+", ");	
				}
				System.out.println();
			}
		}
		
	}
	

}
