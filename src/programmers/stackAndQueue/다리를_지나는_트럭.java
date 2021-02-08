package programmers.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class �ٸ���_������_Ʈ�� {
	public static void main(String[] args) {
		int answer = Solution.solution(2, 10, new int[]{ 7});
		System.out.println("answer : "+answer);
	}	
	
	static class Solution {
	    public static int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 0;
	        Queue<Integer> q = new LinkedList<>();
	        int max = 0;
	        for(int w : truck_weights) {
	        	while(true) {
	        		if(q.isEmpty()) {
	        			q.offer(w);
	        			answer++;
	        			max += w;
	        			break;
	        		} else if(q.size() == bridge_length) {
	        			max -= q.poll();
	        		} else {
	        			if(max + w > weight) {
	        				q.offer(0);
	        				answer++;
	        			} else {
	        				q.offer(w);
	        				max += w;
	        				answer++;
	        				break;
	        			}
	        		}
	        	}
	        }
	        return answer + bridge_length;
	    }
	}
}
