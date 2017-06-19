package beakjoon.dp;

import java.util.Scanner;

/**
 * Created by Administrator on 2017-06-19.
 * D[i] = 가장 긴 바이토닉 수열의 길이 = k까지 가장 긴 바이토닉 수열 길이 + n~k까지 가장 긴 바이토닉 수열 길이
 * if(a[j] < a[i] && d[i] < d[j]+1) d[i] = d[j]+1;
 */
public class T11054_LongBitonic_DP {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a1[] = new int[n];
        int a2[] = new int[n];
        int d1[] = new int[n];
        int d2[] = new int[n];
        for(int i = 0; i < n; i++) {
            int value = scan.nextInt();
            a1[i] = value;
            a2[n-1-i] = value;
        }

        longTermLogic(n, a1, d1);
        longTermLogic(n, a2, d2);

        int result = 0;
        for(int i = 0; i < n; i++) {
            int value = d1[i] + d2[n - 1 - i];
            result = result < value ? value : result;
        }

        System.out.println(result-1);
    }

    private static void longTermLogic(int n, int[] a, int[] d) {
        for(int i = 0; i < n; i++) {
            d[i] = 1;
            for(int j = 0; j < i; j++) {
                if(a[j] < a[i] && d[i] < d[j]+1) d[i] = d[j]+1;
            }
        }
    }
}
