package dataStructure.sort;

public class bubbleSort {
	public static void main(String[] args) {
		int[] arr = { 29, 10, 14, 37, 13 };
		print(arr, "Previous");
		bubbleSort(arr);
		print(arr, "Sorted");
	}

	public static void bubbleSort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
	}

	public static void print(int[] arr, String message) {
		System.out.print(message + " : ");
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}
}
