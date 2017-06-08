package beakjoon.dp;

import java.util.Scanner;

/**
 * Created by youngjae on 2016. 9. 4..
 * d[i][j] = 길이가 i이고 마지막 수가 j인 오르막수 =
 */
public class T11057_AEScount_DP {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long arr[][] = new long[n+1][10];
        final long mod = 10007;

        for(int i = 0 ; i <= 9; i++) {
            arr[1][i] = 1;
        }
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j<= 9; j++) {
                for(int k = 0; k <= j; k++) {
                    arr[i][j] += arr[i-1][k];
                    arr[i][j] %= mod;
                }
            }
        }
        long a = 0;
        for(int i = 0; i<= 9; i++) {
            a += arr[n][i];
        }
        System.out.println(a %= mod);
    }
}
