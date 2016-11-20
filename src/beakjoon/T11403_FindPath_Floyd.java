import java.util.Scanner;

/**
 * Created by youngjae on 2016. 11. 20..
 */
public class T11403_FindPath_Floyd {
    static int n;
    static int arr[][];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(arr[j][i] == 1 && arr[i][k] == 1) {
                        arr[j][k] = 1;
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
