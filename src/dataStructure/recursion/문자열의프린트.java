package dataStructure.recursion;

public class ���ڿ�������Ʈ {
	public static void main(String[] args) {
		printChars("�ȳ��ϼ��� �ݰ�����");
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
