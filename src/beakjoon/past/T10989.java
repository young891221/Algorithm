package beakjoon.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class T10989 {
	static int n;
	static int[] number = new int[10001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		
		long start = System.currentTimeMillis();
		for(int i = 1; i <= 10000; i++)
			number[i] = 0;
		for(int i = 1; i <= n; i++)
			number[Integer.parseInt(reader.readLine())]++;
		
		StringBuilder builder = new StringBuilder();
		for(int i = 1; i <= 10000; i++) {
			if(number[i] != 0) {
				builder.append(i).append("\n");
				number[i]--;
				i--;
			}
		}
		long end = System.currentTimeMillis() - start;
		System.out.println("time = "+end/1000);
		System.out.println(builder.toString());
	}

}
