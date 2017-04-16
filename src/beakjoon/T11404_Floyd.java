import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by youngjae on 2016. 11. 20..
 */
public class T11404_Floyd {
    private static final int INF = 100000000;
    static int n, m;
    static int arr[][];
    static ArrayList<Integer>[][] list;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n+1][n+1];
        list = new ArrayList[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = INF;
            }
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                list[i][j] = new ArrayList<>();
            }
        }

        for(int i = 1; i <= m; i++) {
            int first = scan.nextInt();
            int second = scan.nextInt();
            int value = scan.nextInt();
            if(arr[first][second] > value) {
                arr[first][second] = value;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(arr[j][k] > arr[j][i] + arr[i][k]) {
                        arr[j][k] = arr[j][i] + arr[i][k];
                        if(!list[j][k].contains(j)) {
                            list[j][k].add(j);
                        }
                        //if(list[j][k].contains(k)) { list[j][k].remove(list[j][k].size()-1); }
                        list[j][k].add(i);
                        list[j][k].add(k);
                    } else {
                        if(list[j][k].isEmpty()) {
                            list[j][k].add(j);
                            list[j][k].add(k);
                        }
                    }

                    if(j == k) {
                        arr[j][k] = 0;
                        list[j][k].clear();
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print(list[i][j].size() + " ");
                for(int x : list[i][j]) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }
    }
}
