package leetcode;
import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "(()(";
		solution(test);
	}
	
	public static boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(char str : arr) {
        	if(str == '(') {
        		stack.add(str);
        	} else if(str == ')') {
        		if(stack.isEmpty()) {
        			return false;
        		}
        		stack.pop();
        	}
        }
        
        if(stack.isEmpty()) {
        	return true;
        }

        return answer;
    }
}
