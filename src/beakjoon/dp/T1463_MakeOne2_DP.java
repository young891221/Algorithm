package beakjoon.dp;

import java.util.Scanner;

/**
 * Created by KimYJ on 2016-08-18.
 * 잘 알고 있는지 테스트
 */
public class T1463_MakeOne2_DP {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] d = new int[n+1];
        d[1] = 0;
        for(int i = 2; i <= n; i++) {
            d[i] = d[i-1] + 1; //안좋은 경우의 수를 먼저 메모이제이션 수행, 이후 2와 3에 대해 더 좋은 경우의 수가 있으면 갱신

            if(i%2 == 0 && d[i] > d[i/2] + 1) {
                d[i] = d[i/2] + 1;
            }

            if(i%3 == 0 && d[i] > d[i/3] + 1) {
                d[i] = d[i/3] + 1;
            }
        }
        System.out.println(d[n]);
    }
}
