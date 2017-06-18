package beakjoon.dp;

import java.util.Scanner;

/**
 * Created by Administrator on 2017-06-14.
 */
public class T2156_Grape_DP {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n+1];
        int d[] = new int[n+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = scan.nextInt();
        }

        d[1] = arr[1];
        if (n >= 2) d[2] = arr[1] + arr[2];
        for(int i = 3; i <= n; i++) {
            d[i] = d[i-1];
            d[i] = Math.max(d[i], d[i-2]+arr[i]); //한칸 떨어져 있을 때
            d[i] = Math.max(d[i], d[i-3]+arr[i-1]+arr[i]); //이전꺼랑 붙어 있을 때
        }
        int result = d[1];
        for (int i = 2; i <= n; i++) {
            result = Math.max(result, d[i]);
        }
        System.out.println(result);
    }
}
