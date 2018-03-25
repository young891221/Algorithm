import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3 {

    private static int n;
    private static boolean[][] graph;
    private static int cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String arr[] = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = "1".equals(arr[j]);
            }
        }

        int m = Integer.parseInt(br.readLine());

        System.out.println(findCycle(graph, m) ? 1 : 0);
    }

    private static boolean findCycle(boolean[][] graph, int m) {
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //로직을 돌면서 사이클이 m과 같을 경우 반환
                if(cycle == m) return true;
            }
        }*/
        return false;
    }

    private static void dfs(int x) {
        //사이클이면서 m과 같으면
    }

}
