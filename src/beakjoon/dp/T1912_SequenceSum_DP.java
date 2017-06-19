package beakjoon.dp;

import java.util.Scanner;

/**
 * Created by Administrator on 2017-06-19.
 * D[i] = i까지 연속된 랜덤 수의 최대 합 = if(d[i] < a[i] + cache) d[i] = a[i] + cache
 * 한 개 이상 선택
 * 1 <= n <= 100,000
 * -1000 < 입력 < 1000
 */
public class T1912_SequenceSum_DP {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        int d[] = new int[n];
        for(int i = 0; i < n; i++) {
           a[i] = scan.nextInt();
        }

        d[0] = a[0];
        for(int i = 1; i < n; i++) {
            d[i] = a[i];
            int cache = 0;
            for(int j = i-1; j >= 0; j--) {
                cache += a[j];
                if(d[i] < a[i] + cache) d[i] = a[i] + cache;
            }
        }

        int result = -1000;
        for(int i = 0; i < n; i++) {
            result = result < d[i] ? d[i] : result;
        }
        System.out.println(result);
    }

}
