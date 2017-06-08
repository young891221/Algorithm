package beakjoon.dp;

import java.util.Scanner;

/**
 * Created by youngjae on 2016. 8. 20..
 */
public class T11727_Tiling2_DP {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n+1];

        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i <= n; i++) {
            arr[i] = 2*arr[i-2] + arr[i-1];
            arr[i] %= 10007;
        }
        System.out.println(arr[n]);
    }

}