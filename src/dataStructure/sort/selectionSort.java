package dataStructure.sort;

public class selectionSort {
	public static void main(String[] args) {
		int[] arr = { 29, 10, 14, 37, 13 };
		print(arr, "Previous");
		selectionSort(arr);
		print(arr, "Sorted");
	}

	public static void selectionSort(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int min = i;
			for (int j = i + 1; j < len; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
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
