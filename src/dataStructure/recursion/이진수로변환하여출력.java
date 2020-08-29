package dataStructure.recursion;

public class 이진수로변환하여출력 {
	public static void main(String[] args) {
		printInBinary(10);
	}
	
	public static void printInBinary(int n) {
		if(n<2) {
			System.out.print(n);
		} else {
			printInBinary(n/2); 
			System.out.print(n%2);
		}
	}
}
