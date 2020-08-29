package dataStructure.recursion;

public class 배열합의합구하기 {
	public static void main(String[] args) {
		int[] data = { 1,2,3,4,};
		System.out.println(sum(data.length, data));
	}
	
	public static int sum(int n, int[] data) {
		if(n<=0) {
			return 0;
		} else {
			return sum(n-1, data) + data[n-1];
		}
	}
}
