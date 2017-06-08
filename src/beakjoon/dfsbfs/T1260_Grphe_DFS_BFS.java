package beakjoon.dfsbfs;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by youngjae on 2016. 8. 13..
 */
public class T1260_Grphe_DFS_BFS {
	static int n, m, v, f ,b;
	static int a[][];
	static Map<Integer, Integer> map;
	static Scanner scan;
	static Queue<Integer> q;
	static boolean check[];
	

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		v = scan.nextInt();

		a = new int[10][10];
		for(int i = 0; i < m; i++) { //인접행렬방식으로 그래프 구현(O(V^2))
			f = scan.nextInt();
			b = scan.nextInt();
			a[f][b] = a[b][f] = 1;
		}
		
		/*map = new HashMap<Integer, Integer>();
		for(int i = 0; i < m; i++) { //인접리스트로 그래프 구현(O(E))
			f = scan.nextInt();
			b = scan.nextInt();
			map.put(f, b);
			map.put(b, f);
		}*/
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.println(a[i][j]);
			}
		}
        check = new boolean[n];
		dfs(1);
        q = new LinkedList<Integer>();
	}
	
	static void dfs(int x) {
		check[x] = true;
		System.out.println(x);
		for(int i = 1; i<= n; i++) {
			if(a[x][i] == 1 && check[i] == false) {
				dfs(i);
			}
		}
	}

	static void bfs(int x) {
	    check[x] = true;
        q.add(x);
        while(!q.isEmpty()) {
            x = q.remove();

        }
    }
}
