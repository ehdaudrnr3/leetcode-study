package leetcode.medium.stack;

import java.util.Stack;

public class DailyTemperatures {
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] rs = sol.dailyTemperatures(T);
		sol.print(rs);
		
	}
}
class Solution {
	public int[] dailyTemperatures(int[] T) {
       int[] rs = new int[T.length];
       Stack<Integer> st = new Stack<>();
       for (int i = 0; i < T.length; i++) {
		
    	   while(!st.isEmpty() && T[i] > T[st.peek()]) {
    		   int idx = st.pop();
    		   rs[idx] = i - idx;
    	   }
    	   st.push(i);
       }
       return rs;
    }
	public void print(int[] prints) {
		for (int print : prints) {
			System.out.print(print+", ");
		}
	}
}