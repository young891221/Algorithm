import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by youngjae on 2016. 10. 22..
 */
public class T1707_BipartiteGraph_BFS {
    static ArrayList<Integer>[] list;
    static Queue<Integer> q;
    static int check[];
    static boolean result;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        while(k-- > 0) {
            int v = scan.nextInt();
            int e = scan.nextInt();
            list = new ArrayList[v+1];
            check = new int[v+1];

            for(int i = 1; i <= v; i++) {
                list[i] = new ArrayList<Integer>();
            }
            for(int i = 1; i <= e; i++) {
                int first = scan.nextInt();
                int second = scan.nextInt();
                list[first].add(second);
                list[second].add(first);
            }
            for(int i = 1; i <= v; i++) {
                if(check[i] == 0) {
                    bfs(v, i);
                }
            }

            if(result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static void bfs(int v, int a) {
        q = new LinkedList<Integer>();
        q.add(a);
        check[a] = 1;
        result = true;

        while(!q.isEmpty()) {
            int x = q.remove();
            for(int i : list[x]) {
                if(check[i] == 0) {
                    q.add(i);
                    if(check[x] == 2) {
                        check[i] = 1;
                    } else if(check[x] == 1) {
                        check[i] = 2;
                    }
                }
            }
        }

        for (int i=1; i <= v; i++) {
            for (int j : list[i]) {
                if (check[i] == check[j]) {
                    result= false;
                }
            }
        }
    }
}
