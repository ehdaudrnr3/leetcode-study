package dataStructure.recursion;

public class 문자열의프린트 {
	public static void main(String[] args) {
		printChars("안녕하세요 반가워요");
	}
	
	public static void printChars(String str) {
		if(str == null || str.length() == 0) {
			return;
		} else {
			System.out.print(str.charAt(0));
			printChars(str.substring(1));
		}
		
	}
}
