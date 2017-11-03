package beakjoon.dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

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
    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = new FileInputStream("C:/Users/Kim YJ/Desktop/2579.txt");
        Scanner scanner = new Scanner(new InputStreamReader(in));
        //Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n+2];
        int d[][] = new int[n+2][3];

        for(int i = n-1; i >= 0; i--) {
            a[i] = scanner.nextInt();
        }

        int result = dp(n, a, d);
        System.out.println(result);
    }

    private static int dp(int n, int[] a, int[][] d) {
        int result = 0;
        d[0][1] = a[0];
        d[1][2] = d[0][1] + a[1];
        d[2][1] = d[0][1] + a[2];
        for(int i = 2; i < n; i++) {
            for(int j = 1; j < 3; j++) {
                if(j == 1) {
                    int key = d[i-2][1] > d[i-2][2] ? 1 : 2;
                    d[i][1] = d[i-2][key] + a[i];
                }
                if(j == 2) {
                    d[i][2] = d[i-1][1] + a[i];
                }
                result = result < d[i][j] ? d[i][j] : result;
            }
        }
        return result;
    }
}
