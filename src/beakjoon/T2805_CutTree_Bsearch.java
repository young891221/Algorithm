package beakjoon;

import java.util.Scanner;

/**
 * Created by KimYJ on 2016-08-26.
 */
public class T2805_CutTree_Bsearch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long m = scan.nextLong();
		long arr[] = new long[n];
		long h = 0;

		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
			h = Math.max(h, arr[i]);
		}



	}

	static boolean check(long[] arr, long h, long m) {
		long length = 0;
		for(long a : arr) {
			long result = a - h;
			if(result > 0) {
				length += result;
			}
		}

		return length >= m;
	}
}
