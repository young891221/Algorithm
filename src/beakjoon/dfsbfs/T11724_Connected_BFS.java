package beakjoon.dfsbfs;

import java.util.*;

/**
 * Created by Administrator on 2016-10-18.
 * 연걸리스트의 노드가 1개짜리인것도 케이스가 추가 될 수 있도록 해야함
 */
public class T11724_Connected_BFS {
    static int n;
    static int m;
    static int need;
    static int result = 0;
    static ArrayList<Integer>[] list;
    static boolean check[];
    static Queue<Integer> q = new LinkedList<Integer>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++) {
            int first = scan.nextInt();
            int second = scan.nextInt();
            list[first].add(second);
            list[second].add(first);
        }

        logic();
    }

    static void logic() {
        check = new boolean[n+1];

        for(int i = 1; i <= n; i++) {
            if(!check[i]) {
                bfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    static void bfs(int next) {
        q.add(next);
        check[next] = true;

        while(!q.isEmpty()) {
            int x = q.remove();
            for(int i : list[x]) {
                if(!check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
