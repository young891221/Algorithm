package beakjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2017-06-12.
 */
public class T9465_Sticker_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        while (T-- > 0) {
            int n = Integer.valueOf(br.readLine());
            long[][] arr = new long[2][n+1];

            String[] upLine = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                arr[0][i] = Long.valueOf(upLine[i-1]);
            }

            String[] downLine = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                arr[1][i] = Long.valueOf(downLine[i-1]);
            }

            long[][] d = new long[n+1][3];
            for (int i = 1; i <= n; i++) {
                d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
                d[i][1] = Math.max(d[i-1][0], d[i-1][2]) + arr[0][i];
                d[i][2] = Math.max(d[i-1][0], d[i-1][1]) + arr[1][i];
            }
            long ans = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
            System.out.println(ans);

            /*long none = dp(n-1, 0, arr);
            long up = dp(n-1, 1, arr);
            long down = dp(n-1, 2, arr);
            System.out.println(Math.max(Math.max(none, up), down));*/
        }
    }

    private static long dp(int n, int check, long[][] arr) {
        if(n == 0) return arr[check == 0 ? 0 : check - 1][n];
        if(check == 0) {
            return Math.max(Math.max(dp(n-1, 0, arr), dp(n-1, 1, arr)), dp(n-1, 2, arr));
        } else if(check == 1) {
            return Math.max(dp(n-1, 0, arr), dp(n-1, 2, arr)) + arr[0][n];
        }
        return Math.max(dp(n-1, 0, arr), dp(n-1, 1, arr)) + arr[1][n];
    }
}
