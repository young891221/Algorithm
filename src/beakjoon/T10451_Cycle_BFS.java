package beakjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Administrator on 2016-10-25.
 */
public class T10451_Cycle_BFS {
    static int n;
    static int list[];
    static Queue<Integer> q;
    static boolean check[];
    static int result;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        while(T-- > 0) {
            n = scan.nextInt();
            result = 0;
            list = new int[n+1];
            for(int i = 1; i <= n; i++) {
                list[i] = scan.nextInt();
            }
            check = new boolean[n+1];
            for(int i = 1; i <= n; i++) {
                if(!check[i]) {
                    bfs(i);
                }
            }
            System.out.println(result);
        }

    }

    static void bfs(int nextItem) {
        q = new LinkedList();
        q.add(nextItem);
        check[nextItem] = true;

        while(!q.isEmpty()) {
            int next = list[q.remove()];
            if(!check[next]) {
                q.add(next);
                check[next] = true;
            } else {
                result++;
            }
        }
    }
}
