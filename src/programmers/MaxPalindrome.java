package programmers;

public class MaxPalindrome {

	public static void main(String[] args) {
		//String s = "abaaabba";
		//String s = "abacde";
		String s = "abcdcba";
		int start = 0;
		int end = s.length() - 1;

		int max = solution2(s);
		System.out.println(max);
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
