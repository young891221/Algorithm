package beakjoon.dp;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by youngjae on 2016. 8. 20..
 * 이 문제는 출력하는 수가 워낙 크기때문에 BigInteger를 사용하여 배열을 꾸렸다
 */
public class T1793_Tiling_DP {
    static int n;
    static BigInteger arr[] = new BigInteger[251];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()) {
            n = scan.nextInt();
            arr[0] = BigInteger.ONE;
            arr[1] = BigInteger.ONE;

            for(int i = 2; i <= n; i++) {
                arr[i] = arr[i-2].multiply(BigInteger.valueOf(2)).add(arr[i-1]);
            }

            System.out.println(arr[n]);
        }

    }
}
