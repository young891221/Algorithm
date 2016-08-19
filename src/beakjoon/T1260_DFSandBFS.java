package beakjoon;

import java.util.*;

/**
 * Created by KimYJ on 2016-08-16.
 */
public class T1260_DFSandBFS {
    static int n, m, v, first, second;
    static int arr[][];
    static boolean check[];
    static Queue<Integer> q;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        v = scan.nextInt();

        arr = new int[n+1][n+1];
        //그래프 만들기
        for(int i = 0; i < m; i++) {
            first = scan.nextInt();
            second = scan.nextInt();
            arr[first][second] = arr[second][first] = 1;
        }
        check = new boolean[n+1];
        dfs(v);
        System.out.println();
        q = new LinkedList<Integer>();
        check = new boolean[n+1];
        bfs(v);
    }

    static void dfs(int x) {
        check[x] = true;
        System.out.print(x+" ");
        for(int i = 1; i <= n; i++) {
            if(arr[x][i] == 1 && check[i] == false) {
                dfs(i);
            }
        }
    }

    static void bfs(int x) {
        check[x] = true;
        q.add(x);
        while(!q.isEmpty()) {
            x = q.remove();
            System.out.print(x+" ");
            for(int i = 1; i <= n; i++) {
                if(arr[x][i] == 1 && check[i] == false) {
                    check[i] = true;
                    q.add(i);
                }
            }
        }
    }

}
