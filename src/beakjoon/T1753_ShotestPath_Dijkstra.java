package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KimYJ on 2016-11-07.
 */
class Edge {
    int to, cost;
    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class T1753_ShotestPath_Dijkstra {
    static final int INF = 1000000000;
    static int v, e, start, selectMin;
    static List<Edge>[] list;
    static int dist[];
    static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first[] = reader.readLine().split(" ");
        v = Integer.parseInt(first[0]);
        e = Integer.parseInt(first[0]);
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

        for(int i = 1; i <= v; i++) {
            dist[i] = INF;
        }

        dist[start] = 0;
        for(int i = 1; i <= v; i++) {
            int min = INF;
            for(int j = 1; j <= v; j++) {
                if(!check[j] && min > dist[j]) {
                    min = dist[j];
                    selectMin = j;
                }
            }
            check[selectMin] = true;
            for(Edge x : list[selectMin]) {
                if(dist[x.to] > dist[selectMin] + x.cost) {
                    dist[x.to] = dist[selectMin] + x.cost;
                }
            }
        }

        for(int i = 1; i <= v; i++) {
            if(dist[i] != INF) {
                System.out.println(dist[i]);
            } else {
                System.out.println("INF");
            }
        }

    }
}
