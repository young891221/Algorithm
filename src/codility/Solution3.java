package codility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution3 {

	static final String insertMsg = "INSERT";
	static final String deleteMsg = "DELETE";
	static final String swapMsg = "SWAP";
	static final String nothingMsg = "NOTHING";
	static final String impossibleMsg = "IMPOSSIBLE";

	public static String solution(String S, String T) {

		int SLength = S.length();
		int TLength = T.length();

		if (S.equals(T))
			return nothingMsg;

		if (SLength > TLength) { // deleteTest

			if (SLength - TLength == 1) {

				for (int i = 0; i < SLength; i++) {

					if (i < TLength) {
						if (T.charAt(i) != S.charAt(i)) {
							if (T.substring(i).equals(S.substring(i + 1)))
								return deleteMsg + " " + S.charAt(i);
							else
								break;
						}
					} else
						return deleteMsg + " " + S.charAt(i);

				}
			}

		} else if (SLength == TLength) {

			boolean flag = false;
			List<Integer> list = new ArrayList<Integer>();
			int cnt = 0;
			for (int i = 0; i < SLength; i++) {
				if (S.charAt(i) != T.charAt(i)) {
					list.add(i);
					cnt++;

					if (cnt > 2) {
						flag = true;
						break;
					}
				}
			}
			if (flag)
				return impossibleMsg;

			if (cnt == 2) {
				String msg = swapMsg;
				for (int tmp : list)
					msg += " " + S.charAt(tmp);

				return msg;
			}
		} else {

			if (TLength - SLength == 1) { // insertTest

				for (int i = 0; i < TLength; i++) {

					if (i < TLength - 1) {
						if (T.charAt(i) != S.charAt(i)) {
							if (T.substring(i).equals(
									T.charAt(i) + S.substring(i)))
								return insertMsg + " " + T.charAt(i);
							else
								break;
						}
					} else
						return insertMsg + " " + T.charAt(i);

				}
			}

		}

		return impossibleMsg;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String S = scan.next();
		String T = scan.next();
		System.out.println(solution(S, T));
	}

}