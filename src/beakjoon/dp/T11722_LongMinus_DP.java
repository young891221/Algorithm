package beakjoon.dp;

import java.util.Scanner;

/**
 * Created by Administrator on 2017-06-18.
 * d[i] = 가장 길게 감소하는 수열의 길이 수
 */
public class T11722_LongMinus_DP {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        int d[] = new int[n];

        for(int i = n-1; i >= 0; i--) {
            a[i] = scan.nextInt();
        }

        for(int i = 0; i < n; i++) {
            d[i] = 1;
            for(int j = 0; j < i; j++) {
                if(a[j] < a[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }

        int result = d[0];
        for(int i = 1; i < n; i++) {
            if(result < d[i]) result = d[i];
        }
        System.out.println(result);
    }
}
