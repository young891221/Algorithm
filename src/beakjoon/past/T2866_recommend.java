import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 이거와 같은 경우는 내가 풀었던 방식과는 다르게 정렬해서 두개씩 비교하므로 속도가 더 빠르다.
 * HashSet에 하나씩 모두 넣으며 비교하는 것보다 미리 정렬하는게 더 효율적
 */
public class T2866_recommend {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(buf.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		String[] table = new String[R];

		for (int i = 0; i < R; i++) {
			table[i] = buf.readLine();
		}

		StringBuilder sb = new StringBuilder();
		String[] rotatedTable = new String[C];

		for (int i = 0; i < C; i++) {
			for (int j = R-1; j >=0; j--) {
				sb.append(table[j].charAt(i));
			}
			rotatedTable[i] = sb.toString();
			sb = new StringBuilder();
		}

		Arrays.sort(rotatedTable);

		int max = 0;

		for (int i = 0; i < C-1; i++) {
			int pos = 0;

			//정렬을 했으니 두개씩 비교
			while(rotatedTable[i].charAt(pos) == rotatedTable[i+1].charAt(pos)) {
				pos++;
			}

			max = max > pos ? max : pos;
		}

		System.out.println(R - max - 1);

		buf.close();
	}

}
