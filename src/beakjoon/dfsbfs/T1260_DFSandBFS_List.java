package beakjoon.dfsbfs;

import java.util.*;

/**
 * Created by KimYJ on 2016-08-16.
 */
public class T1260_DFSandBFS_List {
    static int n, m, v, first, second;
    static ArrayList<Integer>[] list;
    static boolean check[];
    static Queue<Integer> q;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        v = scan.nextInt();

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        //그래프 만들기
        for(int i = 0; i < m; i++) {
            first = scan.nextInt();
            second = scan.nextInt();
            list[first].add(second);
            list[second].add(first);
        }
        //각각의 배열 정렬, 정렬이 안되면 틀린다...이유는 입력 받는 수가 정렬되어 입력되지 않을 수 있으므로
        for(int i =1; i <= n; i++) {
            Collections.sort(list[i]);
        }
        check = new boolean[n+1];
        dfs(v);
        System.out.println();
        q = new LinkedList<Integer>();
        Arrays.fill(check, false);
        bfs(v);
    }

    static void dfs(int x) {
        if(check[x]) {
            return;
        }
        check[x] = true;
        System.out.print(x+" ");
        for(int y : list[x]) {
            if(!check[y]) {
                dfs(y);
            }
        }
    }

    static void bfs(int x) {
        check[x] = true;
        q.add(x);
        while(!q.isEmpty()) {
            x = q.remove();
            System.out.print(x+" ");
            for(int y : list[x]) {
                if(!check[y]) {
                    check[y] = true;
                    q.add(y);
                }
            }
        }
    }

}
