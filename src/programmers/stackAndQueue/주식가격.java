package programmers.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class 주식가격 {
	public static void main(String[] args) {
		solution(new int[] {1, 2, 3, 2, 3});
	}
	
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new LinkedList<Integer>();
        
        for (int price : prices) {
			q.offer(price);
		}
        
        for (int i = 0; i < prices.length; i++) {
			Integer poll = q.poll();
			int second = 0;
			
			for (Integer peek : q) {
				if(peek >= poll) {
					second++;
				} else {
					second++; 
					break;
				}
			}
			answer[i] = second;
		}
        return answer;
    }
}

