package beakjoon.dp;

import java.util.Scanner;

/**
 * Created by Administrator on 2017-06-15.
 */
public class T11053_LongTerm_DP {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        int d[] = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && d[i] < d[j]+1) {
                    d[i] = d[j]+1;
                }
            }
        }

        int result = d[0];
        for(int i = 0; i < n; i++) {
            if(result < d[i]) result = d[i];
        }
        System.out.println(result);
    }
}
