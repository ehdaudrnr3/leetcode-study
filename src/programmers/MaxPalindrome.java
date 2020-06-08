package programmers;

import java.util.HashSet;
import java.util.Set;

public class MaxPalindrome {

	public static void main(String[] arg1s) {
		String s= "kagoyzkgfjnyvjewazalxngpdcfahneqoqgiyjgpzobhaghmgzmnwcmeykqzgajlmuerhhsanpdtmrzibswswzjjbjqytgfewiuu";

		for(int i=1;i<s.length();i++) {
			if(s.charAt(i-1) == s.charAt(i)) {
				s = s.replace(s.substring(i-1, i), "") + s.substring(i+1);
				i=0;
			}
		}
        System.out.println(s.length() == 0 ? "Empty String" : s);
		
		//System.out.println(max);
	}

	public static int solution(String s) {
		int answer = 0;

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j <= s.length(); j++) {
				StringBuilder str = new StringBuilder(s.substring(i, j));
				if (s.substring(i, j).equals(str.reverse().toString())) {
					answer = Math.max(answer, str.length());
				}
			}
		}
		return answer;
	}

	public static int solution2(String s) {
		
		String reverse = "";
		for(int i = s.length()-1;i>=0;i--) {
			reverse += s.charAt(i);
		}

		int max = 1;
		for (int i = s.length(); i > 1; i--) {
			for(int j=0;j<=s.length()-i;j++) {
				String str = s.substring(j, j+i);
				if(reverse.contains(str)) {
					max = i;
					return max;
				}
			}
		}
		return max;
	}

}
