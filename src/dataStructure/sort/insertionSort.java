package dataStructure.sort;

public class insertionSort {
	public static void main(String[] args) {
		int[] arr = { 29, 10, 14, 37, 13 };
		print(arr, "Previous");
		insertionSort(arr);
		print(arr, "Sorted");
	}

	public static void insertionSort(int[] arr) {
		int len = arr.length;
		int j = 0;
		for (int i = 1; i < len; i++) {
			int temp = arr[i];
			for (j = i - 1; j>=0 && temp < arr[j]; j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp; 
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
