package hackerRank.string;

/**
 * Difiiculty : Medium
 */
public class Sherlock_and_the_valid_string {
	public static void main(String[] args) {
		String valid = Solution.isValid("aabbcd");
		System.out.println(valid);
	}

	static class Solution {
	    static String isValid(String s) {
	    	int[] dir = new int[26];
	    	
	    	for (char c : s.toCharArray()) {
	    		dir[c-'a']++;
			}
	    	
	    	int max = -1;
	    	boolean isRemove = false;
	    	for (int i = 0; i < dir.length; i++) {
	    		if(dir[i] > 0) {
	    			if(max == -1 || dir[i] == max) {
		    			max = dir[i];
		    			continue;
		    		} else if(!isRemove && (dir[i] == max + 1 || dir[i] == 1)) {
		    			isRemove = true;
		    			continue;
		    		} else {
		    			return "NO";
		    		}
	    		}
			}
	    	return "YES";
	    }
	}
}
