package beakjoon.dp;

import java.util.Scanner;

/**
 * Created by youngjae on 2016. 8. 20..
 * D[i] = D[i-1] + D[i-2] + D[i-3]
 */
public class T9095_OneTwoThree_DP {
    static int n;
    static int arr[] = new int[11];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for(int i = 3; i <= 10; i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        for(int i = 0; i < n; i++) {
            System.out.println(arr[scan.nextInt()]);
        }
    }
}
