package programmers.sort;

import java.util.Arrays;

public class H_Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int answer = sol.solution(new int[]{3, 0, 6, 1, 5});
		System.out.println("answer : "+ answer);
	}
	
	static class Solution {
	    public int solution(int[] citations) {
	        int answer = 0;
	        int len = citations.length;
	        Arrays.sort(citations);
	        for(int i =0; i < len; i++) {
	            int h = len - i;
	            if(citations[i] >= h) return h;
	        }
	        return answer;
	    }
	}
}
