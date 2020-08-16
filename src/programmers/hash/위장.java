package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class ¿ß¿Â {
	public static void main(String[] args) {
		String[][] clothes1 = new String[][] { 
			{ "yellow_hat", "headgear" },
			{ "blue_sunglasses", "eyewear" },
			{ "green_turban", "headgear" } 
		};

		String[][] clothes2 = new String[][] { 
			{ "crow_mask", "face" }, 
			{ "blue_sunglasses", "face" },
			{ "smoky_makeup", "face" } 
		};

		Solution sol = new Solution();
		System.out.println(sol.solution(clothes1));
		System.out.println(sol.solution(clothes2));
	}

	static class Solution {
		public int solution(String[][] clothes) {
			int answer = 1;
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < clothes.length; i++) {
				String kind = clothes[i][1];
				map.put(kind, map.getOrDefault(kind, 0) + 1);
			}

			for (String key : map.keySet()) {
				answer *= map.get(key) + 1;
			}

			return answer - 1;
		}
	}
}
