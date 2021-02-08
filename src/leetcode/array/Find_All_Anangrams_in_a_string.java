package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Anangrams_in_a_string {

	public static void main(String[] args) {
		Solution sol = new Solution();
		List<Integer> answers = sol.findAnagrams("cbaebabacd", "abc");
		for (Integer data : answers) {
			System.out.println(data);
		}
	}
	
	static class Solution {
	    public List<Integer> findAnagrams(String s, String p) {
	    	
	    	int[] freq = new int[26];
	    	for (char c : p.toCharArray()) {
				freq[c-'a']++;
			}
	    	
	    	List<Integer> list = new ArrayList<>();
	    	int diff = p.length();
	    	for (int i = 0, j = 0; i < s.length(); i++) {
	    		if(freq[s.charAt(i) - 'a']-- > 0) diff--;
	    		while(diff == 0) {
	    			if(i - j + 1 == p.length()) list.add(j);
	    			if(++freq[s.charAt(j++) - 'a'] > 0) diff++;
	    		}
			}
	    	return list;
	    }
	    
	}
}	
