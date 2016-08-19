package beakjoon.past;

import java.util.Scanner;

public class T1035 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		char A[][] = new char[5][5];
		String B[] = new String[5];
		
		for(int i = 0; i < 5; i++) {
			B[i] = scan.nextLine();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				A[i][j] = B[i].charAt(j);
			}
		}
		
		/*for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println(A[i][j]);
			}
		}*/
	}

}
