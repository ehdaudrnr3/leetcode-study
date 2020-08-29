package programmers.완전탐색;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {

	public static void main(String[] args) {
		int[] answers1 = new int[] { 1, 2, 3, 4, 5 };
		int[] answers2 = new int[] { 1, 3, 2, 5, 2 };
		Solution sol = new Solution();
		int[] solution1 = sol.solution(answers1);
		sol.print(solution1);

		int[] solution2 = sol.solution(answers2);
		sol.print(solution2);
	}

	static class Solution {
		public int[] solution(int[] answers) {
			int[] target1 = new int[] { 1, 2, 3, 4, 5 };
			int[] target2 = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
			int[] target3 = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
			int score1 = 0, score2 = 0, score3 = 0;

			for (int i = 0; i < answers.length; i++) {
				int answer = answers[i];

				if (answer == target1[i % 5])
					score1++;
				if (answer == target2[i % 8])
					score2++;
				if (answer == target3[i % 10])
					score3++;
			}

			int max = Math.max(score1, Math.max(score2, score3));
			List<Integer> list = new ArrayList<>();

			if (score1 == max)
				list.add(1);
			if (score2 == max)
				list.add(2);
			if (score3 == max)
				list.add(3);

			int[] sol = new int[list.size()];
			for (int j = 0; j < list.size(); j++) {
				sol[j] = list.get(j);
			}
			return sol;
		}

		public void print(int[] result) {
			for (int i : result) {
				System.out.println(i);
			}
		}
	}
}
