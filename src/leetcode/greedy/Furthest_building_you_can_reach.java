package leetcode.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

public class Furthest_building_you_can_reach {

	public static void main(String[] args) {
		int[] heights = {4,12,2,7,3,18,20,3,19};
		int bricks = 10;
		int ladders = 2;
		int answer = Solution.furthestBuilding(heights, bricks, ladders);
		System.out.println("Answer : " + answer);
	}
	
	static class Solution {
	    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
	    	Queue<Integer> q = new PriorityQueue<Integer>();
	        for (int i = 0; i < heights.length - 1; i++) {
	        	int diff = heights[i+1] - heights[i];
	        	if(diff > 0) {
	        		q.offer(diff);
	        	}
	        	if(q.size() > ladders) {
	        		bricks -= q.poll();
	        	}
	        	if(bricks < 0) {
	        		return i;
	        	}
			}
	        return heights.length - 1;
	    }
	}
}
