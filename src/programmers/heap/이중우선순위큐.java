package programmers.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class 이중우선순위큐 {

	public static void main(String[] args) {
		//String[] operations = { "I 7", "I 5", "I -5", "D -1"};
		String[] operations = { "I 16", "D 1"};
		int[] answer = Solution.solution(operations);
		System.out.println("max : "+ answer[0] + ", min : "+ answer[1]);
	}
	
	static class Solution {

		public static int[] solution(String[] operations) {
	        int[] answer = new int[2];
	        
	        Queue<Integer> minQ= new PriorityQueue<>((a, b)-> a- b);
	        Queue<Integer> maxQ= new PriorityQueue<>((a, b)-> b-a);
	        
	        for (int i = 0; i < operations.length; i++) {
				String[] oparr = operations[i].split(" ");
				String operator = oparr[0];
				int num = Integer.parseInt(oparr[1]);
				
				if(operator.equalsIgnoreCase("I")) {
					maxQ.add(num);
					minQ.add(num);
				}else {
					if(num > 0) {
						Integer poll = maxQ.poll();
						minQ.remove(poll);
					} else if(num < 0) {
						Integer poll = minQ.poll();
						maxQ.remove(poll);
					}
				}
			}
	        
	        if(!maxQ.isEmpty() && !minQ.isEmpty()) {
	        	answer[0] = maxQ.poll();
	        	answer[1] = minQ.poll();
	        }
	        return answer;
	    }
	}
}
