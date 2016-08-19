package beakjoon.past;

import java.util.Scanner;

public class POLY {
	
	static int MOD = 1*1000*1000;
	int N = 12;
	static int count = 0;
	static int[][] box;
	
	static int poly(int n, int first) {
		
		if(n == first) return 1;
		
		int ret = box[n][first];
		if(ret != -1) return ret;
		ret = 0;
		
		for(int second = 1; second <= n-first; ++second){
			int add = second + first-1;
			int sum = poly(n-first, second);
			count++;
			
			int temp = n-first;
			box[temp][second] = sum;
			
			add = add * sum;
			add %= MOD;
			
			ret += add;
			ret %= MOD;
		}
		
		return ret;

	}
	
	void stack(){
		
	}
	
	/* 1. �������̳븦 ���� �� �ִ� ����� ��(�������̳����� �ƴ��� Ȯ��)
	 * 2. �������� �ƴ���
	 */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int[] a = new int[T];
		for (int i = 0; i < T; i++) {
			if(a[0]>=1 && a[0]<=50)
				a[i] = scan.nextInt();
			else
				return;
			if(a[0]>=1 && a[0]<=100)
				a[i] = scan.nextInt();
			else
				return;
		}
		for (int i = 0; i < T; i++) {
			int data = poly(a[i], 1);
			System.out.println(data);
		}

	}

}
