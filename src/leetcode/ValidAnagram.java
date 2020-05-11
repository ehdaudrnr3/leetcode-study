package leetcode;
import java.util.Arrays;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram";
		String t = "nagaram";
		
		isAnagram(s, t);
	}
	
	public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
        	return false;
        }
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        for(int i =0;i<sArr.length;i++) {
        	if(Character.compare(sArr[i], tArr[i]) != 0) {
        		return false;
        	}
        }
        return true;
        
    }
}
