package hackerRank.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Difficulty : Easy
 * 
 * @author mgpc
 * @url https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
public class MakingAnagrams {
	public static void main(String[] args) {
		String a = "fcrxzwscanmligyxyvym";
		String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
		
		int answer = makeAnagram(a, b);
		System.out.println("answer : "+answer);
	}

	static int makeAnagram(String a, String b) {
		int[] freq = new int[26];
		for (char c : a.toCharArray()) {
			freq[c-'a']++;
		}
		for (char d : b.toCharArray()) {
			freq[d-'a']--;
		}
		return Arrays.stream(freq).map(Math::abs).sum();
	}
}
