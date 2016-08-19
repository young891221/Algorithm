package algospot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ALLERGY {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt(); //테스트 케이스
		int n = scan.nextInt(); //사람수
		int m = scan.nextInt(); //음식수
		String man[] = new String[n]; //사람이름 배열
		
		//inset man
		for (int i = 0; i < n; i++) {
			man[i] = scan.next();
			System.out.println(man[i]);
		}
		
		//insert food
		List list = new ArrayList<Map<Integer, String>>();
		Map<Integer, String> map = new HashMap<Integer, String>();
		int first = 0;
		String second = null;
		String third = null;
		for (int i = 0; i < m; i++) {
			first = scan.nextInt();
			second = scan.next();
			third = scan.next();
			map.put(first, second+" "+third);
			list.add(map);
		}
		
		for(int i = 0; i < m; i++) {
			System.out.println(list.get(i));
		}
		
		
	}
}
