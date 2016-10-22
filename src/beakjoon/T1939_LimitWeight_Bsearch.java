import java.util.Scanner;

/**
 * Created by youngjae on 2016. 10. 15..
 * 다리와 중량의 무게를 받고 맨 마지막에 2개의 섬을 이어줄 수 있는 중량을 찾아야 한다.
 * 중량을 초과하면 기존의 다리가 무너지기 때문에 무너지지 않고 이어질 수 있는 최대 중량을 찾아야 하는 문제이다.
 * BFS, 이분탐색...
 */
public class T1939_LimitWeight_Bsearch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        long bridge[][] = new long[n+1][n+1];
        int island1, island2 = 0;

        //init!
        //똑같은 섬사이의 다리가 여러번 나올 수 있음
        for (int i = 0; i < m; i++) {
            int l = scan.nextInt();
            int r = scan.nextInt();
            if (bridge[l][r] == 0) {
                bridge[l][r] = scan.nextInt();
            } else {
                bridge[l][r] = Math.max(bridge[l][r], scan.nextInt());
            }
        }
        island1 = scan.nextInt();
        island2 = scan.nextInt();

        //배열 [섬1][섬2] or [섬2][섬1] searching 하기
        //여러개의 다리가 나오는 경우의 수만 넣어주면 된다
        //2중 for문...
        System.out.println(bridge[island1][island2] >= bridge[island2][island1] ? bridge[island1][island2] : bridge[island2][island1]);
    }
}
