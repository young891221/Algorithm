package beakjoon.dp;

import java.util.Scanner;

/**
 * Created by youngjae on 2016. 12. 3..
 */
public class T11052_Bunahbbang_DP {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n+1];
        int b[] = new int[n+1];
        for(int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                b[i] = Math.max(b[i], a[j] + b[i-j]);
            }
        }

        System.out.println(b[n]);
    }
}
