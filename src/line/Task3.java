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
4
0111
1000
1000
0010
3
 */
public class Task3 {

    private static int n;
    private static int cnt = 0;
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
            for (int j = 0; j < n; j++) {
                if("1".equals(arr[j])) {
                    list[0].add(j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            Collections.sort(list[i]);
        }

        int m = Integer.parseInt(br.readLine());

        isCheck = new boolean[n];
        isFinished = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!isCheck[i]) dfs(i);
        }

        //System.out.println(findCycle(m) ? 1 : 0);
    }

    private static void dfs(int x) {
        isCheck[x] = true;
        for(int y : list[x]) {
            if(isCheck[y]) {
                if(!isFinished[y]) {
                    //for(int temp = y; temp!=y; temp = list[temp])	cnt++;
                    cnt++;
                }
            }
            else {
                dfs(y);
            }
            isFinished[y] = true;
        }
    }

}
