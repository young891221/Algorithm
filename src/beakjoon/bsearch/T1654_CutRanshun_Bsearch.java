package beakjoon.bsearch;

import java.util.Scanner;

/**
 * Created by KimYJ on 2016-08-26.
 4 11
 802
 743
 457
 539
 */
public class T1654_CutRanshun_Bsearch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		int n = scan.nextInt();
		long arr[] = new long[k];
		long max = 0;
		for(int i = 0; i < k; i++) {
			arr[i] = scan.nextLong();
			max = Math.max(max, arr[i]);
		}
		long ans = 0;
		long l = 1;
		long r = max;
		while(l <= r) {
			long mid = (l+r) / 2;
			if(check(arr, n, mid)) {
				ans = Math.max(ans, mid);
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		System.out.println(ans);
	}

	static boolean check(long[] arr, int n, long mid) {
		int cnt = 0;
		for (long a : arr) {
			cnt += (a/mid);
		}
		return cnt >= n;
	}
}
