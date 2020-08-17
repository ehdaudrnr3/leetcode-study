package programmers.greedy;

public class Ã¼À°º¹ {
	public static void main(String[] args) {
		int n1 = 5;
		int[] lost1 = new int[] { 2, 4};
		int[] reserve1 = new int[] { 1, 3, 5};
		
		int n2 = 5;
		int[] lost2 = new int[] { 2, 4};
		int[] reserve2 = new int[] { 3};
		
		int n3 = 3;
		int[] lost3 = new int[] { 3 };
		int[] reserve3 = new int[] { 1};
		
		Solution sol = new Solution();
		System.out.println(sol.solution(n1, lost1, reserve1));
		System.out.println(sol.solution(n2, lost2, reserve2));
		System.out.println(sol.solution(n3, lost3, reserve3));
		
	}
	
	static class Solution {
		public int solution(int n, int[] lost, int[] reserve) {
	        int answer = n;
	        
	        for(int i=0; i < lost.length; i++) {
	        	boolean rent = false;
	        	int j = 0;
	        	while(!rent) {
	        		if(j == reserve.length) break;
	        		else if(lost[i] == reserve[j] || lost[i] - reserve[j] == 1 || lost[i] - reserve[j] == -1) {
	        			reserve[j] = -1;
	        			rent = true;
	        		} 
	        		else {
	        			j++;
	        		}
	        	}
	        	
	        	if(!rent) answer--;
	        }
	        
	        return answer;
	    }
	}
}

