package dataStructure.recursion;

public class 최대값찾기 {
	public static void main(String[] args) {
		int[] data = { 4, 5, 7, 30, 100};
		System.out.println(findMax(data, 0, data.length-1));
		System.out.println(findMaxMid(data, 0, data.length-1));
	}
	
	public static int findMax(int[] data, int begin, int end) {
		if(begin == end) 
			return data[begin];
		else 
			return Math.max(data[begin], findMax(data, begin+1, end));
	}
	
	public static int findMaxMid(int[] data, int begin, int end) {
		if(begin == end) 
			return data[begin];
		else {
			int mid = (begin+end) / 2;
			int left = Math.max(data[begin], findMax(data, begin, mid));
			int right = Math.max(data[begin], findMax(data, mid+1, end));
			return Math.max(left, right);
		}
		
	}
}

