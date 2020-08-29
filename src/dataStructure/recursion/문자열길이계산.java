package dataStructure.recursion;

public class 문자열길이계산 {
	public static void main(String[] args) {
		System.out.println(length("abc"));
	}
	
	public static int length(String str) {
		if(str == null || str.equals("")) {
			return 0;
		} else {
			return 1+length(str.substring(1));
		}
	}
}
