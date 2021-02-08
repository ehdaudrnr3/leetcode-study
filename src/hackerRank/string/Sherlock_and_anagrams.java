package hackerRank.string;

import java.util.ArrayList;
import java.util.List;

public class Sherlock_and_anagrams {

	public static void main(String[] args) {
		int answer = sherlockAndAnagrams("abba");
		System.out.println("answer : "+ answer);
	}
	static int sherlockAndAnagrams(String s) {
		
		int count = 0;
        int length = s.length();

        List<String> subsets = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                subsets.add(s.substring(i, j+1));
            }
        }
        
        for (int i = 0; i < subsets.size(); i++) {
        	for (int j = i+1; j < subsets.size(); j++) {
        		String c = subsets.get(i);
        		String t = subsets.get(j);
				if(c.length() == t.length() && isAnagram(c, t)) {
					count++;
				}
			}
		}
        return count;	
    }
	private static boolean isAnagram(String c, String t) {
		int[] cr = new int[26];
		int[] tr = new int[26];
		
		for (char ch : c.toCharArray()) {
			cr[ch - 'a']++; 
		}
		for (char ch : t.toCharArray()) {
			tr[ch - 'a']++;
		}
		
		for (int i = 0; i < 26; i++) {
			if(cr[i] != tr[i]) return false;
			
		}
		return true;
	}

}	
