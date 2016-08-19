package beakjoon.past;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Treasure_1026 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		if (n < 51) {
			Integer A[] = new Integer[n];
			Integer B[] = new Integer[n];
			Integer subB[] = new Integer[n];
			int result = 0;
			
			for (int i = 0; i < n; i++) {
				A[i] = scan.nextInt();
			}
			for (int i = 0; i < n; i++) {
				B[i] = scan.nextInt();
				subB[i] = B[i];
			}

			Arrays.sort(A, Collections.reverseOrder());
			Arrays.sort(subB);
			
			for (int i = 0; i < n; i++) {
				result += (A[i]*subB[i]);
			}
			
			System.out.println(result);
		}

	}
}
