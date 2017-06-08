package beakjoon.dp;

import java.util.Scanner;

/**
 * Created by youngjae on 2016. 8. 20..
 * Top-Bottom 스타일 도전~
 */
public class T9095_OneTwoThree2_DP {
    static int n;
    static int arr[] = new int[11];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        dp(10);
        for(int i = 0; i < n; i++) {
            System.out.println(arr[scan.nextInt()]);
        }
    }

    static int dp(int x) {
        if(x == 0 || x == 1) arr[x] = 1;
        if(x == 2) arr[x] = 2;
        if(arr[x] > 0) return arr[x];

        if(arr[x-1] == 0) {
            dp(x-1);
        }
        if(arr[x-2] == 0) {
            dp(x-2);
        }
        if(arr[x-3] == 0) {
            dp(x-3);
        }
        arr[x] = arr[x-1] + arr[x-2] + arr[x-3];

        return x;
    }
}
