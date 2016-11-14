package beakjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Administrator on 2016-11-14.
 */
public class T1504_SpecialShotest_Dijkstra {
    static final int INF = 100000000;
    static int n, e, v1, v2;
    static ArrayList<Edge>[] list;
    static PriorityQueue<Edge> pq;
    static int dist[];
    static boolean check[];

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
        e = scan.nextInt();
        list = new ArrayList[n+1];
        pq = new PriorityQueue<>();
        dist = new int[n+1];
        check = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 1; i <= e; i++) {
            int first = scan.nextInt();
            int second = scan.nextInt();
            int third = scan.nextInt();
            list[first].add(new Edge(second, third));
            list[second].add(new Edge(first, third));
        }
        v1 = scan.nextInt();
        v2 = scan.nextInt();

        int result1 = beforeShotest(new int[]{1, v1, v2, n});
        int result2 = beforeShotest(new int[]{1, v2, v1, n});
        if(result1 > result2) { result1 = result2; }
        if(result1 >= INF) { result1 = -1; }
        System.out.println(result1);
    }

    static int beforeShotest(int[] each) {
        int result = 0;
        for(int i = 0; i < 3; i++) {
            int index1 = each[i];
            int index2 = each[i+1];
            shotest(index1);
            result += dist[index2];
            System.out.println(dist[index2]);
        }
        return result;
    }

    static void shotest(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Edge(start, dist[start]));

        while(!pq.isEmpty()) {
            int min = pq.remove().vertex;
            if(check[min]) continue;
            check[min] = true;

            for(Edge x : list[min]) {
                int to = x.vertex;
                int cost = x.distance;
                if(dist[to] > dist[min] + cost) {
                    dist[to] = dist[min] + cost;
                    pq.add(new Edge(to, dist[to]));
                }
            }
        }
    }
}
