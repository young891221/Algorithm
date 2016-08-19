package beakjoon.past;

import java.util.Scanner;

public class T1080 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		if(n < 51 && m < 51) {
			//행렬생성
			int A[][] = new int[n][m];
			int B[][] = new int[n][m];
			String s[] = new String[2*n]; 
			
			for(int i = 0; i < (2*n); i++) {
				s[i] = scan.nextLine();
			}
			System.out.println(s[0].length());
			
			//행렬 값 입력
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					System.out.println(s[i].charAt(j));
					A[i][j] = s[i].charAt(j);
				}
			}
			/*for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					B[i][j] = scan.nextInt();
				}
			}*/
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					System.out.println(A[i][j]);
				}
			}
			
			
		} else {
			System.out.println(-1);
		}
		
	}

}
