package beakjoon.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class T2866 {
	static char[][] arr;
	static String[] read;
	static int a;
	static int b;
	static int aSub;
	static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scan = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long start = System.currentTimeMillis();
		
		read = in.readLine().split(" ");
		a = Integer.parseInt(read[0]);
		b = Integer.parseInt(read[1]);
		aSub = a;

		arr = new char[a][b];
		// 1. 데이터 넣기
		for (int i = 0; i < a; i++) {
			String str = in.readLine();
			for (int j = 0; j < b; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		while (aSub != 0) {
			// 2. 문자열별 데이터 정렬하기(배열 처리 방법)
			int minus = a - aSub;
			String[] temp = new String[b];
			for (int i = 0; i < b; i++) {
				for (int j = 0; j < a - minus; j++) {
					if (temp[i] == null) {
						temp[i] = String.valueOf(arr[j + minus][i]);
					} else {
						temp[i] = temp[i].concat(String
								.valueOf(arr[j + minus][i]));
					}
				}
			}
			
			int cnt = 0;
			ArrayList<String> list = new ArrayList<String>();
			HashMap<Integer, String> table = new HashMap<Integer, String>();
			//3. 문자열 비교
			l: while (true) {

				if (cnt + 1 == b)
					break;

				for (int i = 0; i < b; i++) {
					if (table.containsValue(temp[i])) {
						break l;
					} else {
						table.put(i, temp[i]);
					}
					//System.out.println(table.get(i));
				}

				cnt++;
				if (aSub != a)
					count++;
				// list.clear();

			}

			aSub--;
		}

		if (aSub == 0)
			System.out.println(count);
		long end = System.currentTimeMillis();
		
	    System.out.println( (end-start)/1000 + "초");
	}

}
