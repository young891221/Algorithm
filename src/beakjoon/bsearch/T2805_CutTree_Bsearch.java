package beakjoon.bsearch;

import java.util.Scanner;

/**
 * Created by KimYJ on 2016-08-26.
 */
public class T2805_CutTree_Bsearch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long m = scan.nextLong();
		long arr[] = new long[n+1];
		long h = 0;
		long length = 0;

		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
			h = Math.max(h, arr[i]);
		}
		long ans = 0;
		while(length <= h) { //이 조건문이 이해 불가...
			long mid = (length + h)/2;
			System.out.println("mid = "+mid+" length = "+length+" h = "+h);
			if(check(arr, mid, m)) {
				ans = Math.max(ans, mid);
				length = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		System.out.println(ans);
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
