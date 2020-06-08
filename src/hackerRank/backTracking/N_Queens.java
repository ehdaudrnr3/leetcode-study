package hackerRank.backTracking;

public class N_Queens {
	public static void main(String[] args) {
		N_Queen q = new N_Queen(4);
		q.backTracking(0);
	}
}

class N_Queen {
	private int N;
	private int cols[];
	
	public N_Queen(int N) {
		this.N = N;
		cols = new int[N];
	}
	
	public void backTracking(int level) {
		if(level == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(cols[i]);
			}
			System.out.println("");
		} else {
			for(int i=0;i<N;i++) {
				cols[level] = i;
				if(isPossible(level)) {
					backTracking(level+1);
				}
			}
		}
	}

	private boolean isPossible(int level) {
		for(int i=0;i<level;i++) {
			if(cols[i]==cols[level] || Math.abs(level-i)== Math.abs(cols[level]-cols[i])){
				return false;
			}
		}
		return true;
	}
}
