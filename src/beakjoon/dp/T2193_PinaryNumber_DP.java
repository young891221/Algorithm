package beakjoon.dp;

import java.util.Scanner;

/**
 * Created by Administrator on 2017-06-11.
 * 이친수는
 * 0으로 시작하지 않고 1이 두번 연속 나오지 않는 것
 * 입력으로 자릿수를 입력받고 이친수가 되는 모든 갯수 출력
 */
public class T2193_PinaryNumber_DP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] arr = new long[91][2];
        arr[1][0] = 0;
        arr[1][1] = 1; //첫번째는 1만 올 수 있음
        for (int i = 2; i <= n; i++) { //0으로 끝나는 경우 1, 0 둘다 오는 갯수, 1로 끝나는 경우 0으로 오는 갯수
            arr[i][0] = arr[i-1][0] + arr[i-1][1];
            arr[i][1] = arr[i-1][0];
        }
        System.out.println(arr[n][0] + arr[n][1]);
    }

    private static void solution2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] d = new long[n+1];
        d[1] = 1;
        if (n >= 2) {
            d[2] = 1;
        }
        for (int i=3; i<=n; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        System.out.println(d[n]);
    }
}
