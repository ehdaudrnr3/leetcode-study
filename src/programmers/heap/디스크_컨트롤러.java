package programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크_컨트롤러 {
	public static void main(String[] args) {
		int[][] jobs = {
				{0, 3}, 
				{1, 9},
				{2, 6}
		};
		int solution = Solution.solution(jobs);
		System.out.println("Answer : "+solution);
	}
	static class Solution {
	    public static int solution(int[][] jobs) {
	        int index = 0;
	        int jobidx = 0;
	        int time = 0;
	        int wastingTime = 0;
	        
	        Arrays.sort(jobs, (a,b)-> a[0] - b[0]);
	        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
	       
	        while(index < jobs.length) {
	        	while(jobidx < jobs.length && jobs[jobidx][0] <= time) {
	        		q.offer(jobs[jobidx++]);
	        	}
	        	
	        	if(q.isEmpty()) {
	        		time = jobs[jobidx][0];
	        	} else {
	        		int[] job = q.poll();
	        		wastingTime += (job[1] + time) - job[0];
	        		time += job[1];
	        		index++;
	        	}
	        }
	        return wastingTime / jobs.length;
	    }
	}
}
