import java.util.Scanner;

/**
 * Created by youngjae on 2016. 9. 4..
 * d[i][j] = 길이가 i이고 마지막 수가 j = d[i-1][j-1] + d[i-1][j+1] (j-1, j+1은 위아래로 1차이가 났을 때)
 * 어렵당...아직 완벽한 이해 안됨..
 */
public class T10844_EasyFloor_DP {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[][] = new int[n+1][10];
        final long mod = 1000000000L;

        for(int i = 1; i <= 9; i++) {
            arr[1][i] = 1;
        }
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= 9; j++) {
                arr[i][j] = 0;
                if(j-1 >= 0) arr[i][j] += arr[i-1][j-1];
                if(j+1 <= 9) arr[i][j] += arr[i-1][j+1];
                arr[i][j] %= mod;
            }
        }

        long a = 0;
        for(int i = 0; i <= 9; i++) {
            a += arr[n][i];
        }
        System.out.println(a %= mod);
    }
}
