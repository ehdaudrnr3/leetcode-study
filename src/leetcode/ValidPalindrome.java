package leetcode;

public class ValidPalindrome {
	public static void main(String[] args) {	
		String s= "A man, a plan, a canal: Panama";
		System.out.println(isValid(s));
	}
	
	public static boolean isValid(String s) {
		String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		String reverse = new StringBuffer(actual).reverse().toString(); 
		
		return actual.equals(reverse);
	}
}
