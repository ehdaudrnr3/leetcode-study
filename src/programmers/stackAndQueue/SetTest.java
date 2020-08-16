package programmers.stackAndQueue;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		int solution = solution(new int[] { 1, 3, 6, 4, 1, 2 });
		System.out.println("Solution : " + solution);
	}

	public static int solution(int[] A) {
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;
		for (int i : A) {
			set.add(i);
			max = Math.max(i, max);
		}

		for (int i = 1; i <= max; i++) {
			if (!set.contains(i)) {
				return i;
			} 
			if(max == i){
				return i + 1;
			}
		}
		return max;
	}
}
