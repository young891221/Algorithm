package beakjoon.dijkstra;

import java.util.Scanner;

/**
 * Created by youngjae on 2016. 10. 29..
 * 인접리스트는 클래스를 따로 구형해야 되므로 일단 인접행렬!
 */
public class T1916_Minimum_Dijkstra {
    static final int INF = 1000000000; //각 간선의 가중치를 무한대로 초기화(최소값을 구하기 위해)
    static int[][] arr;
    static int dist[];
    static boolean check[];
    static int n, m, start, end, min, selectMin = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n+1][n+1];
        dist = new int[n+1];
        check = new boolean[n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = INF;
            }
        }

        for(int i = 1; i <= m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            if(arr[a][b] > c) {
                arr[a][b] = c;
            }
        }

        start = scan.nextInt();
        end = scan.nextInt();

        for(int i = 1; i <= n; i++) {
            dist[i] = INF;
        }

        dist[start] = 0;
        for(int i = 1; i <= n; i++) {
            min = INF;

            for(int j = 1; j <= n; j++) {
                if(!check[j] && min > dist[j]) {
                    min = dist[j];
                    selectMin = j;
                }
            }
            check[selectMin] = true; //가장 가까운 정점을 방문

            for(int j = 1; j <= n; j++) {
                if(dist[j] > dist[selectMin] + arr[selectMin][j]) { //방문한 정점을 통해 다른 정점까지의 거리가 짧아지는 지
                    dist[j] = dist[selectMin] + arr[selectMin][j];
                }
            }
        }

        System.out.println(dist[end]);
    }


}
