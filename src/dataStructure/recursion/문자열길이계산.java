package dataStructure.recursion;

public class ���ڿ����̰�� {
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
