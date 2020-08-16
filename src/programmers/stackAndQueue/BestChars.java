package programmers.stackAndQueue;

public class BestChars {
	public static void main(String[] args) {
		System.out.println(solution("hhhelaabbbazzzlo"));
	}
	
	static String solution(String S) {
		  int[] occurrences = new int[26];
	        for (char ch : S.toCharArray()) {
	               occurrences[ch - 'a']++;
	        }

	        char best_char = 'a';
	        int  best_res  = 0;

	        for (int i = 0; i < occurrences.length; i++) {
	            if (occurrences[i] > best_res) {
	                best_char = (char)((int)'a' + i);
	                best_res  = occurrences[i];
	            }
	        }

	        return Character.toString(best_char);
    }
}
