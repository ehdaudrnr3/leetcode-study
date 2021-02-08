package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_anagrams {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
		List<List<String>> groupAnagrams = sol.groupAnagrams(strs);
		System.out.println(groupAnagrams);
	}
	
	static class Solution {
	    public List<List<String>> groupAnagrams(String[] strs) {
	    	Map<String, List<String>> m= new HashMap<>();
	        for (String str : strs) {
	        	char[] chars = str.toCharArray();
				Arrays.sort(chars);
				String valueOf = String.valueOf(chars);
				
				List<String> list = m.getOrDefault(valueOf, new ArrayList<>());
				list.add(str);
				m.put(valueOf, list);
			}
	        
	        return new ArrayList<>(m.values());
	    }
	}
}
