package programmers.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
	public static void main(String[] args) {
		int[] progresses = { 50, 93, 30, 55};
		int[] speeds = {20, 1, 30, 5};
		int[] solution = solution(progresses, speeds);
		for (int i : solution) {
			System.out.println(i);
		}
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> a = new LinkedList<>();
		
        for (int i = 0; i <= progresses.length-1; i++) {
        	q.offer(ceil(progresses[i], speeds[i]));
		}
        
        int prev = q.poll();
        int count = 1;
        while(!q.isEmpty()) {
        	Integer cur = q.poll();
        	if(prev >= cur) {
        		count++;
        	} else {
        		a.offer(count);
        		count = 1;
        		prev = cur;
        	}
        }
        a.add(count);
        
        int[] answer = new int[a.size()];
        int i = 0;
        while(!a.isEmpty()) {
        	answer[i++] = a.poll();
        }
        return answer;
    }
	
	private static int ceil(int progress, int speed) {
		return (100 - progress) % speed == 0 ? (100 - progress) / speed : ((100 - progress) / speed) + 1;
	}
}
