package dataStructure.recursion;

public class BinarySearch {
	public static void main(String[] args) {
		int[] data = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println(binarySearch(data, 0, data.length-1, 3));
	}
	
	public static int binarySearch(int[] data, int begin, int end, int target) {
		if(begin > end) 
			return -1;
		else {
			int mid = (begin+end) / 2;
			if(data[mid] == target) {
				return mid;
			} else if(target < data[mid]) {
				return binarySearch(data, begin, mid-1, target);
			} else { 
				return binarySearch(data, mid+1, end, target);
			}
		}
	}
}
