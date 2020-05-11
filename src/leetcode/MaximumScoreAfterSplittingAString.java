package leetcode;

public class MaximumScoreAfterSplittingAString {
	public static void main(String[] args) {
		System.out.println(maxScore("011101"));
	}
	
	public static int maxScore(String s) {
        int left = 0, right = 1, max = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '0') left++; else right--;
            if(i != s.length()-1) max = Math.max(left + right, max);
        }
        return max - right; 
    }
}
