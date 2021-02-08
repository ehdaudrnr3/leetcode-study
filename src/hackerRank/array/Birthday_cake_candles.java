package hackerRank.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Birthday_cake_candles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> asList = Arrays.asList(3,2,1,3);
		int answer = birthdayCakeCandles(asList);
		System.out.println("Answer : " + answer);
	}
	
	public static int birthdayCakeCandles(List<Integer> candles) {
		Map<Integer, Integer> m = new HashMap<>();
		
		int max = Integer.MIN_VALUE;
		for (Integer candle : candles) {
			max = Math.max(max, candle);
			m.put(candle, m.getOrDefault(candle, 0) + 1);
		}
		return m.get(max);
    }
}
