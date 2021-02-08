package hackerRank.string;

public class TimeConversion {

	public static void main(String[] args) {
		String answer = timeConversion("07:05:45PM");
		System.out.println("answer : " + answer);
	}

	static String timeConversion(String s) {
		String[] strings = s.split(":");
		String year = strings[0];
		String month = strings[1];
		String time = strings[2].substring(0, 2);
		String text = strings[2].substring(2);
		if (text.equals("AM")) {
			if (year.equals("12")) {
				return year = "00" + ":" + month + ":" + time;
			} 
		} else {
			int yyyy = Integer.parseInt(year);
			if (!year.equals("12")) {
				yyyy += 12;
			}
			year = String.valueOf(yyyy);
		}
		
		return year + ":" + month + ":" + time;

	}
}
