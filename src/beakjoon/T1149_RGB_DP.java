import java.util.Scanner;

/**
 * Created by youngjae on 2017. 5. 5..
 * 빨/초/파
 * 이웃된 집은 같은 색 안되고, 최소의 비용으로 칠할 수 있도록!
 * 로직
 * color 배열에는 모든 자리값의 수를 받기
 * minBySum 배열에 각각의 자리수마다 다른 값의 수를 더해가면서 최소값을 채워나가기
 * 마지막에 각각의 자리수의 최소값들을 비교하여 결과 도출
 */
public class T1149_RGB_DP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int color[][] = new int[n][3];
        long minBySum[][] = new long[n][3];

        for(int i = 0; i < n; i++){
            color[i][0] = sc.nextInt();
            color[i][1] = sc.nextInt();
            color[i][2] = sc.nextInt();
        }

        //First values init
        minBySum[0][0] = color[0][0];
        minBySum[0][1] = color[0][1];
        minBySum[0][2] = color[0][2];

        for(int i = 1; i < n; i++){
            minBySum[i][0] = color[i][0] + Math.min(minBySum[i-1][1], minBySum[i-1][2]);
            minBySum[i][1] = color[i][1] + Math.min(minBySum[i-1][0], minBySum[i-1][2]);
            minBySum[i][2] = color[i][2] + Math.min(minBySum[i-1][0], minBySum[i-1][1]);
        }

        long result = Math.min(minBySum[n-1][0], minBySum[n-1][1]);
        result = Math.min(result, minBySum[n-1][2]);

        System.out.println(result);
    }
}
