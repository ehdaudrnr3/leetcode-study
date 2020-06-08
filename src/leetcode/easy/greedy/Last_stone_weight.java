package leetcode.easy.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

public class Last_stone_weight {
	public static void main(String[] args) {
		int[] stones = { 2, 7, 4, 1, 8, 1};
		
		Solution solution = new Solution();
		int result = solution.lastStoneWeight(stones);
		System.out.println("This is answer : "+result);
	}
}

class Solution {
    public int lastStoneWeight(int[] stones) {
    	Queue<Integer> q = new PriorityQueue<Integer>((a, b)-> { return b-a; });
    	
    	for(int stone : stones) {
    		q.offer(stone);
    	}
    	
    	while(q.size() > 1) {
    		q.offer(q.poll() - q.poll());
    	}
    
        return q.poll();
    }
}