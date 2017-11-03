package beakjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2017-06-20.
 * 계단 연속 세개 x, 한 번에 한 계단/두 계단, 첫 계단은 안밟아도 되지만 마지막은 꼭 밟아야 된다
 * d[i][j] = i: 계단 순서, j: 몇번 연속인지
 * i까지 최대 합 = 거꾸로 마지막 계단부터 시작해서 내려가는 최대 합을 구해도 된다
8
100
100
200
200
0
0
1
100
 */
public class T2579_UpStairs_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n+2];
        int d[][] = new int[n+2][2];

        for(int i = n-1; i >= 0; i--) {
            a[i] = Integer.parseInt(br.readLine());
        }

        dp(n, a, d);
    }

    private static void dp(int n, int[] a, int[][] d) {
        int result = 0;
        d[0][0] = a[0];
        d[1][1] = d[0][0] + a[1];
        d[2][0] = d[0][0] + a[2];
        for(int i = 2; i < n; i++) {
            d[i][0] = getMax(d[i-2]) + a[i];
            d[i][1] = d[i-1][0] + a[i];
            result = result < getMax(d[i]) ? getMax(d[i]) : result; //거꾸로 수행하기에 꼭 마지막을 밟는게 아니므로 맥스 캐시값이 필요
        }
        System.out.println(result);
    }

    private static int getMax(int[] ints) {
        return Math.max(ints[0], ints[1]);
    }
}
