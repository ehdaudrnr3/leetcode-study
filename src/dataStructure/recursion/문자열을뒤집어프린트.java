package dataStructure.recursion;

public class ���ڿ�������������Ʈ {
	public static void main(String[] args) {
		printCharsReverse("123456789");
	}
	
	public static void printCharsReverse(String str) {
		if(str.equals("")) {
			return;
		} else {
			printCharsReverse(str.substring(1));
			System.out.print(str.charAt(0));
			
		}
	}
}
