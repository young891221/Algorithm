package beakjoon;

import java.util.*;

/**
 * Created by Administrator on 2016-10-17.
 */
public class Test {
    static int n;
    static int m;
    static int start;
    static ArrayList<Integer>[] list;
    static Queue<Integer> q;
    static boolean check[];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        start = scan.nextInt();
        list = new ArrayList[n+1];

        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 1; i <= n; i++) {
            int first = scan.nextInt();
            int second = scan.nextInt();
            list[first].add(second);
            list[second].add(first);
        }

        for(int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }
        check = new boolean[n+1];
        dfs(start);
        System.out.println();
        bfs();
    }

    static void dfs(int x) {
        if(check[x]) {
            return;
        }
        check[x] = true;
        System.out.print(x + " ");
        for(int i : list[x]) {
            dfs(i);
        }
    }

    static void bfs() {
        q = new LinkedList<Integer>();
        check = new boolean[n+1];
        q.add(start);
        check[start] = true;
        while(!q.isEmpty()) {
            int node = q.remove();
            System.out.print(node + " ");
            for(int i = 0; i < list[node].size(); i++) {
                int a = list[node].get(i);
                if(!check[a]) {
                    q.add(a);
                    check[a] = true;
                }
            }
        }
    }
}
