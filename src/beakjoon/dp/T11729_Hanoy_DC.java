package dp;

import java.util.Scanner;

/**
 * Created by youngjae on 2017. 5. 9..
 */
public class T11729_Hanoy_DC {
    private static StringBuilder builder;
    private static int n, count = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        builder = new StringBuilder();

        solve(n, 1, 3);

        System.out.println(count);
        System.out.println(builder.toString());
    }

    private static void solve(int n, int x, int y) {
        if(n == 0) return;
        solve(n-1, x, 6-y-x);
        count++;
        builder.append(x+ " " + y + "\n");
        solve(n-1, 6-y-x, y);
    }
}
