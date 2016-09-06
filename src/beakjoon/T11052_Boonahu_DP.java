import java.util.Scanner;

/**
 * Created by youngjae on 2016. 8. 20..
 * D[i] = i개의 붕어빵을 팔 때의 최대 수익 = Max(p[j] + D[i-j])
 */
public class T11052_Boonahu_DP {
    static int n;
    static int p[] = new int[1001];
    static int d[] = new int[1001];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 1; i <= n; i++) {
            p[i] = scan.nextInt();
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                d[i] = max(d[i], d[i-j]+p[j]);
            }
        }
        System.out.println(d[n]);
    }

    static int max(int a, int b) {
        if(b > a) {
            return b;
        }
        return a;
    }
}
