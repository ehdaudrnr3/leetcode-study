package programmers.DFSAndBFS;

public class 네트워크 {
	public static void main(String[] args) {
		int n1 = 3;
		int[][] computers1 = new int[][] {
			{ 1, 1, 0},
			{ 1, 1, 0},
			{ 0, 0, 1}
		};
		
		int n2 = 3;
		int[][] computers2 = new int[][] {
			{ 1, 1, 0},
			{ 1, 1, 1},
			{ 0, 1, 1}
		};
		Solution sol = new Solution();
		int count1 = sol.solution(n1, computers1);
		int count2 = sol.solution(n2, computers2);
		System.out.println(count1);
		System.out.println(count2);
	}
	
	static class Solution {
		public int solution(int n, int[][] computers) {
	        int answer = 0;
	        boolean[] visit = new boolean[n];
	        
	        for(int i=0;i<n;i++) {
	        	if(!visit[i]) {
	        		dfs(computers, i, visit);
	        		answer++;
	        	}
	        }
	        return answer;
	    }

		private void dfs(int[][] computers, int i, boolean[] visit) {
			visit[i] = true;
			
			for(int j=0;j<computers.length;j++) {
				if(i != j && computers[i][j] == 1 && !visit[j]) {
					dfs(computers, j, visit);
				}
			}
			
		}
	}
}
