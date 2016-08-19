package codility;

import java.util.Scanner;

public class Sorting_1920 {

	public static void bubbleSort(int[] arr) {

		boolean flag = false;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = true;
				}
			}
			if (!flag)
				break;
		}
	}

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

	public static int binarySearch(int[] arr, int start, int end, int findNum) {

		if (start > end)
			return 0;

		else {
			int mid = (start + end) / 2;

			if (arr[mid] == findNum)
				return 1;

			else if (arr[mid] > findNum)
				return binarySearch(arr, start, mid - 1, findNum);
			else
				return binarySearch(arr, mid + 1, end, findNum);
		}

	}

	public static void main(String[] args) {

		int n, m;
		int[] arr_n, arr_m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr_n = new int[n];

		for (int i = 0; i < n; i++)
			arr_n[i] = sc.nextInt();

		// bubbleSort(arr_n);
		quickSort(arr_n, 0, arr_n.length - 1);

		m = sc.nextInt();
		arr_m = new int[m];

		for (int i = 0; i < m; i++)
			arr_m[i] = sc.nextInt();

		for (int i = 0; i < m; i++) {
			System.out.println(binarySearch(arr_n, 0, arr_n.length - 1,
					arr_m[i]));
		}
	}

}