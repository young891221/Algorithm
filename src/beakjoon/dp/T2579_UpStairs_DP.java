package beakjoon.dp;

import java.util.Scanner;

/**
 * Created by Administrator on 2017-06-20.
 * 계단 연속 세개 x, 한 번에 한 계단/두 계단, 첫 계단은 안밟아도 되지만 마지막은 꼭 밟아야 된다
 * d[i] = i까지 최대 합 = 거꾸로 마지막 계단부터 시작해서 내려가는 최대 합을 구해도 된다
 * 거꾸로 = if(a[i+1] > a[i+2]) d[i+1] = d[i+1] + a[i], i+= 1
8
100
100
200
200
0
0
1
100
 */
public class T2579_UpStairs_DP {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n+2];
        int d[] = new int[n+2];

        for(int i = n-1; i >= 0; i--) {
            a[i] = scan.nextInt();
        }

        int result = wrongDp(n, a, d);

        System.out.println(result);
    }

    //이전값을 갖고는 있지만 끝 지점에 따라 이전 노드의 최대값이 달라질 수 있으므로 틀린 로직
    private static int wrongDp(int n, int[] a, int[] d) {
        int result = 0;
        d[0] = a[0];
        for(int i = 0; i < n;) {
            if(i == n-1) break;
            d[i+1] = d[i+1] > 0 ? d[i+1] : a[i+1] + d[i];
            d[i+2] = d[i+2] > 0 ? d[i+2] : a[i+2] + d[i];
            if(a[i+1] > a[i+2]) i += 1;
            else i += 2;
            result = result < d[i] ? d[i] : result;
        }
        return result;
    }
}
