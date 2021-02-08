package leetcode.medium.dp;

public class Palindromic_Substring {

	public static void main(String[] args) {
		int answer = Solution.countSubstrings("aaa");
		System.out.println(answer);
	}
	static class Solution {
	    public static int countSubstrings(String s) {
	    	return answerN3(s);
	    }
	    
	    private static int answerN3(String s) {
	    	int ans = 0;
	    	for (int i = 0; i < s.length(); i++) {
				for (int j = i; j < s.length(); j++) {
					ans += isPalindrome(s, i, j) ? 1 : 0;
				}
			}
	    	return ans;
	    }
	    
	    private static boolean isPalindrome(String s, int start, int end) {
	    	while(start < end) {
	    		if(s.charAt(start) != s.charAt(end)) return false;
	    		start++;
	    		end--;
	    	}
	    	return true;
	    }
	}
}
