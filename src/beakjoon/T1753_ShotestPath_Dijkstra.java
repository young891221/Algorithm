package beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by KimYJ on 2016-11-07.
 6 9
 1
 1 2 2
 1 3 3
 1 4 5
 1 5 10
 2 4 2
 3 4 1
 3 5 1
 4 5 3
 5 6 3
 */
public class T1753_ShotestPath_Dijkstra {
    static final int INF = 1000000000;
    static int v, e, start;
    static List<Edge>[] list;
    static int dist[];
    static boolean check[];
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    static class Edge implements Comparable<Edge>{
        private int vertex, distance;
        Edge(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        public int compareTo(Edge o) {
            return distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream("C:/Users/Kim YJ/Desktop/1753.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first[] = reader.readLine().split(" ");
        v = Integer.parseInt(first[0]);
        e = Integer.parseInt(first[1]);
        start = Integer.parseInt(reader.readLine());
        list = new List[v+1];
        dist = new int[v+1];
        check = new boolean[v+1];

        for(int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 1; i <= e; i++) {
            String uvw[] = reader.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]);
            int v = Integer.parseInt(uvw[1]);
            int w = Integer.parseInt(uvw[2]);
            list[u].add(new Edge(v,w));
        }
        Arrays.fill(dist, INF);

        shortestPath();

        for(int i = 1; i <= v; i++) {
            if(dist[i] >= INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

    }

    static void shortestPath() {
        dist[start] = 0;
        pq.add(new Edge(start, dist[start]));

        while(!pq.isEmpty()) {
            int min = pq.remove().vertex;
            if(check[min]) continue; //하위 경로중 이미 수정된 것(continue시 다음 while문으로)
            check[min] = true;

            for(Edge x : list[min]) { //하위 인접리스트 돌면서 최소경로 갱신
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
