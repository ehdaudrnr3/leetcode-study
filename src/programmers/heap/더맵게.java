package programmers.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class ´õ¸Ê°Ô {
	public static void main(String[] args) {
		int[] scoville = new int[] {
			1, 2, 3, 9, 10, 12
		};
		int K = 555;
		
		Solution sol = new Solution();
		int solution = sol.solution(scoville, K);
		System.out.println(solution);
	}
	
	static class Solution {
		public int solution(int[] scoville, int K) {
			int count = 0;
			Queue<Integer> q = new PriorityQueue<>();
			
			for (int sco : scoville) {
				q.offer(sco);
			}
			
			while(q.peek() <= K) {
				if(q.size() == 1) return -1;
				Integer f = q.poll();
				Integer t = q.poll();
				
				int result = f + (t*2);
				q.offer(result);
				count++;
			}
	        	
	        return count;
	    }
	}
}

