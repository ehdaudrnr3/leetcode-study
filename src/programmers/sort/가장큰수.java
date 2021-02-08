package programmers.sort;

import java.util.PriorityQueue;
import java.util.Queue;

public class 가장큰수 {

	public static void main(String[] args) {
		int[] numbers = { 0,0,0,0};
		String answer = Solution.solution(numbers);
		System.out.println("answer : " + answer);
	}
	
	static class Solution {
	    public static String solution(int[] numbers) {
	        Queue<String> q = new PriorityQueue<>((o1, o2) -> (o2+o1).compareTo(o1+o2));
	        for (int num : numbers) {
				String value = String.valueOf(num);
				q.add(value);
			}
	        
	        StringBuilder sb = new StringBuilder();
	        while(!q.isEmpty()) {
	        	if(q.peek().compareTo("0") == 0) return q.poll();
	        	sb.append(q.poll());
	        }
	        
	        return sb.toString();
	    }
	}
}
