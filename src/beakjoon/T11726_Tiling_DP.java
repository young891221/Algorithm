package beakjoon;

import java.util.Scanner;

/**
 * Created by KimYJ on 2016-08-18.
 */
public class T11726_Tiling_DP {
    static int n;
    static int[] d  = new int[1001];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        d[0] = 1;
        d[1] = 1;
        for(int i = 2; i <= n; i++) {
            d[i] = d[i-1] + d[i-2];
            d[i] %= 10007;
        }
        System.out.println(d[n]);
    }
}
