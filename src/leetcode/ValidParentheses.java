package leetcode;

import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		String test = "(]";
		
		Solution solution = new Solution();
		System.out.println(solution.isValid(test));
	}
}

class Solution {
    public boolean isValid(String s) {
    	Stack<Character> st = new Stack<>();
    	
    	for (Character ch : s.toCharArray()) {
    		if(ch == '(' || ch == '{' || ch == '[') {
    			st.add(ch);
    		} else {
    			if(st.isEmpty()) {
    				return false;
    			}
    			if(st.peek() == '(' && ch == ')') {
    				st.pop();
    			} else if(st.peek() == '{' && ch == '}') {
    				st.pop();
    			} else if(st.peek() == '[' && ch == ']') {
    				st.pop();
    			}
    		}
		} 
    	
		return st.isEmpty();
        
    }
}