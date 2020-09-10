package programmers;

public class 요일찾기 {
	public static void main(String[] args) {
		String[] holiday = holiday(1, 6);
		for (int i = 0; i < holiday.length; i++) {
			System.out.println(i+1 + " : " + holiday[i]);
		}

	}

	public static String[] holiday(int date, int day) {
		String[] dayOfWeek = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
		int[] monthDate = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] answer = new String[monthDate.length];

		int total = monthDate[0];
		answer[0] = dayOfWeek[day];

		for (int i = 1; i < monthDate.length; i++) {
			int aggreDate = total + 1;
			int ofDay = (aggreDate - 2) % 7;
			answer[i] = dayOfWeek[ofDay];

			total += monthDate[i] - 1;
		}
		return answer;
	}

}
