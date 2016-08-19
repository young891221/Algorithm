package beakjoon.past;

import java.util.Scanner;

public class Task_1026 {

	static void swap(int[] arr, int first, int last) {
		int temp = arr[first];
		arr[first] = arr[last];
		arr[last] = temp;
	}
	
	static int partition(int[] arr, int left, int right) {

		int pivot = arr[left];
		int low = left + 1;
		int high = right;

		while (low <= high) {

			while (low <= right && arr[low] <= pivot)
				low++;
			while (pivot <= arr[high] && high >= (left + 1))
				high--;

			if (low <= high)
				swap(arr, low, high);
		}
		swap(arr, left, high);

		return high;
	}

	public static void quickSort(int[] arr, int left, int right) {

		if (left <= right) {

			int pivot = partition(arr, left, right);

			quickSort(arr, left, pivot - 1);
			quickSort(arr, pivot + 1, right);
		}

	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int index = scan.nextInt();
		int[] A = new int[index];
		int[] B = new int[index];

		for (int i = 0; i < index; i++)
			A[i] = scan.nextInt();
		for (int i = 0; i < index; i++)
			B[i] = scan.nextInt();

		//��迭
		
		
		
		
		int finish = 0;
		for (int i = 0; i < index; i++) {
			int result = A[i] * B[i];
			finish += result;	
		}
		System.out.println(finish);

	}

}
