package beakjoon.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Administrator on 2016-11-14.
 */
public class T1504_SpecialShotest_Dijkstra {
    static final int INF = 100000000;
    static int node, edge, v1, v2;
    static ArrayList<Edge>[] list;
    static PriorityQueue<Edge> pq;

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
        node = scan.nextInt();
        edge = scan.nextInt();
        list = new ArrayList[node+1];
        pq = new PriorityQueue<>();
        for(int i = 1; i <= node; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 1; i <= edge; i++) { //양방향 가중치 적용
            int first = scan.nextInt();
            int second = scan.nextInt();
            int third = scan.nextInt();
            list[first].add(new Edge(second, third));
            list[second].add(new Edge(first, third));
        }
        v1 = scan.nextInt();
        v2 = scan.nextInt();

        int[] d1 = shotest(1);
        int[] d2 = shotest(v1);
        int[] d3 = shotest(v2);
        int result1 = d1[v1] + d2[v2] + d3[node]; //1 -> 2 -> 3 -> node
        int result2 = d1[v2] + d3[v1] + d2[node]; //1 -> 3 -> 2 -> node

        if(result1 > result2) { result1 = result2; }
        if(result1 >= INF) { result1 = -1; }
        System.out.println(result1);
    }

    static int[] shotest(int start) {
        int dist[] = new int[node+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Edge(start, dist[start]));

        while(!pq.isEmpty()) {
            int min = pq.remove().vertex;
            for(Edge x : list[min]) {
                int to = x.vertex;
                int cost = x.distance;
                if(dist[to] > dist[min] + cost) {
                    dist[to] = dist[min] + cost;
                    pq.add(new Edge(to, dist[to]));
                }
            }
        }

        return dist;
    }
}
