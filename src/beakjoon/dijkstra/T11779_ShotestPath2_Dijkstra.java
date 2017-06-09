package beakjoon.dijkstra;

import java.util.*;

/**
 * Created by youngjae on 2016. 11. 13..
 */
public class T11779_ShotestPath2_Dijkstra {
    static final int INF = 100000000;
    static int n, m, start, end;
    static ArrayList<Edge>[] list;
    static PriorityQueue<Edge> q;
    static int dist[];
    static int path[];
    static boolean check[];
    static Stack<Integer> stack;

    static class Edge implements Comparable<Edge>{
        private int vertex;
        private int distance;

        Edge(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return distance - o.distance;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        list = new ArrayList[n+1];
        stack = new Stack<>();
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 1; i <= m; i++) {
            list[scan.nextInt()].add(new Edge(scan.nextInt(), scan.nextInt()));
        }
        start = scan.nextInt();
        end = scan.nextInt();

        shotest();
        System.out.println(dist[end]);
        int x = end;
        while (x != -1) { //path에 있는 값들 stack에 담기(stack은 끝에서 부터 담김)
            stack.add(x);
            x = path[x];
        }
        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " "); //stack 시작값부터 출력
        }
    }

    static void shotest() {
        q = new PriorityQueue<>();
        dist = new int[n+1];
        path = new int[n+1];
        Arrays.fill(dist, INF);
        check = new boolean[n+1];

        dist[start] = 0;
        path[start] = -1;
        q.add(new Edge(start, dist[start]));

        while(!q.isEmpty()) {
            int min = q.remove().vertex;
            if(check[min]) continue;
            check[min] = true;

            for(Edge x : list[min]) {
                int to = x.vertex;
                int cost = x.distance;
                if(dist[to] > dist[min] + cost) {
                    dist[to] = dist[min] + cost;
                    q.add(new Edge(to, dist[to]));
                    path[to] = min;
                }
            }
        }
    }
}
