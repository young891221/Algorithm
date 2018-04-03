package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 첫줄 노드 갯수 n
 * 마지막줄 사이클을 찾을 길이 m
 * isCheck는 true, isFinished가 false이면 사이클
 * http://www.sbeenlife.com/18
 * http://clearpal7.blogspot.kr/2016/10/cycle.html
 * https://www.acmicpc.net/problem/14441
4
0111
1000
1000
0010
3
 */
public class Task3 {

    private static int n, m, result;
    private static ArrayList<Integer>[] list;
    private static boolean[] isCheck;
    private static boolean[] isFinished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            String arr[] = br.readLine().split("");
            for (int j = 0, length = arr.length; j < length; j++) {
                if("1".equals(arr[j])) {
                    list[i].add(j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            Collections.sort(list[i]);
        }

        m = Integer.parseInt(br.readLine());

        isFinished = new boolean[n];
        isCheck = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!isCheck[i]) {
                result = dfs(i, 1);
            }
        }

        System.out.println(result);
    }

    private static int dfs(int x, int count) {
        isCheck[x] = true;
        for(int y : list[x]) {
            if(isCheck[y]) {
                if(count == m) {
                    return 1;
                }
            }
            else {
                dfs(y, count++);
            }
            isFinished[y] = true;
        }

        return 0;
    }

}
