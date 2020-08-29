package dataStructure.recursion;

public class ¼øÂ÷Å½»ö {
	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 5 };
		System.out.println(search(data, 0, data.length-1, 3));
		System.out.println(searchEnd(data, 0, data.length-1, 4));
	}
	
	public static int search(int[] data, int begin, int end, int target) {
		if(begin > end) {
			return -1;
		} else if(data[begin] == target) {
			return begin;
		} else {
			return search(data, begin+1, end, target);
		}
	}
	
	public static int searchEnd(int[] data, int begin, int end, int target) {
		if(begin > end) {
			return -1;
		} else if(data[end] == target) {
			return end;
		} else {
			return searchEnd(data, begin, end-1, target);
		}
	}
	
	public static int searchMid(int[] data, int begin, int end, int target) {
		if(begin > end) {
			return -1;
		} else {
			int mid = (begin+end) / 2;
			if(data[mid] == target) {
				return mid;
			}
			
			int index = searchMid(data, begin, mid-1, target);
			if(index != -1) {
				return index;
			} else {
				return searchMid(data, mid+1, end, target);
			}
		}
	}
}
