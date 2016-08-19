package algospot;

import java.util.Scanner;

public class T10974_Soonyul {

	static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		//System.out.println("arr[i] = "+arr[i]);
		//System.out.println("arr[j] = "+arr[j]);
	}

	static void permutation(int arr[], int depth, int n, int k) {
		if (depth == k) {
			print(arr);
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			/*System.out.println("swap1");
			System.out.println("i="+i);
			System.out.println("depth="+depth);*/
			permutation(arr, depth + 1, n, k);
			/*System.out.println("swap2");
			System.out.println("i2 = "+i);
			System.out.println("depth2 = "+depth);
			System.out.println("arr = "+arr[i]);*/
			// 위에 있는 permutation 함수때문에 2번이 거꾸로 돌아가게 된다
			swap(arr, i, depth);//되돌아가는 함수...이해가 안된다...
			
		}
	}

	static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1)
				System.out.println(arr[i]);
			else
				System.out.print(arr[i] + " ");
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = i + 1;

		permutation(arr, 0, n, n);
	}

}
