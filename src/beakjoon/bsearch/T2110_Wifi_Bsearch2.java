package beakjoon.bsearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by youngjae on 2016. 10. 9..
 */
public class T2110_Wifi_Bsearch2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = scan.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);

        int x = 1;
        int l = 1;
        int r = arr[n-1] - arr[0];
        while(l <= r) {
            int mid = (l+r)/2;
            if(check(arr, c, mid)) {
                x = Math.max(x, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(x);
    }

    static boolean check(int arr[], int c, int mid) {
        int result = 1;
        int last = arr[0];
        for(int a : arr) {
            if(a - last >= mid) {
                result++;
                last = a;
            }
        }
        return result >= c;
    }
}
