package programmers.stackAndQueue;

import java.util.HashMap;
import java.util.Map;
/*
 * 문자열에서 BALLOON의 가장 적게 발생된 갯수 반환
 */
public class BALLOON {
	public static void main(String[] args) {
		String s1 = "BAONNXXOLL", s2 = "BAOOLLNNOLOLGBAX", s3 = "QAWABAWONL", s4 = "ONLABLABLOON";
		System.out.println(solve(s1));
		System.out.println(solve(s2));
		System.out.println(solve(s3));
		System.out.println(solve(s4));
	}

	private static int solve(String s) {
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> bMap = new HashMap<>();
		for(char c : "BALLOON".toCharArray()) {
			bMap.put(c, bMap.getOrDefault(c, 0) + 1);
		}
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int res = Integer.MAX_VALUE;
		for(Map.Entry<Character, Integer> e : bMap.entrySet()) {
			if(!map.containsKey(e.getKey()))
				return 0;
			res = Math.min(res, map.get(e.getKey()) / e.getValue());
		}
		return res;
	}
}
