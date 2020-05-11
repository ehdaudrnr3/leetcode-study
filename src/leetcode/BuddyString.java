package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BuddyString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        
        int[] dp = new int[sticker.length];
        dp[0] = sticker[sticker.length-1];
        dp[1] = Math.max(sticker[sticker.length-2], sticker[sticker.length-1]);
        
        int j=2;
        for(int i=sticker.length-3;i>=0;i--) {
            dp[j] = Math.max(dp[j-1], dp[j-2]+sticker[i]);
            j++;
        }

        System.out.println(dp[dp.length-1]);
	}
	
//	public boolean buddyStrings(String A, String B) {
//        if(A.length() != B.length()) return false;
//        
//        Set<Character> setA = new HashSet<>();
//        Set<Character> setB = new HashSet<>();
//        
//        for(int i=0;i<A.length();i++) {
//            setA.add(A.charAt(i));
//            setB.add(B.charAt(i));
//        }
//    }
}
