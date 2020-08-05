package programmers.stackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 기능개발
 * @author mgpc
 *
 */
public class FunctionDevelop {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] progresses = { 93, 30, 55};
		int[] speeds = {1,30,5};
		
		int[] answer = sol.solution(progresses, speeds);
		for (int i : answer) {
			System.out.println(i);
		}
	}
}

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> data = new ArrayList<>();
        
        int max = (100 - progresses[0]) / speeds[0];
        int count=1;
        for (int i = 1; i < progresses.length-1; i++) {
        	int value = (100 - progresses[i]) / speeds[i];
        	if(max > value) {
        		count++;
        	} else {
        		data.add(count);
        		count = 1;
        	}
		}
        	
        int[] answer = new int[data.size()];
        for (int j = 0; j < data.size(); j++) {
			answer[j] = data.get(j);
		}
        return answer;
    }
}