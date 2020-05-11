package leetcode;

public class ValidPalindrome2 {
	public static void main(String[] args) {	
		String s= "abca";
		System.out.println(isValid(s));
	}
	
	public static boolean isValid(String s) {
		int start = 0;
		int end = s.length()-1;
		
		while(start < end && s.charAt(start) == s.charAt(end)) {
			start++;
			end--;
		}
		
		if(start >= end) return true;
		return isPalin(s, start+1, end) || isPalin(s, start, end-1);
	}
	
	public static boolean isPalin(String s, int i, int j) {
		while(i<j) {
			if(s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}
}
