package beakjoon;

import java.util.Scanner;

/*
 * 다이나믹 프로그래밍
 * 각각의 case에 대해 메모이제이션 사용
 */
public class T1463_MakeOne_DP {
    static int T;
    static int arr[];
    static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        T = scan.nextInt();
        arr = new int[T+1];
        System.out.println(dp(T));
    }

    static int dp(int n) {
        if(n == 1) return 0; //base value
        if(arr[n] > 0) return arr[n]; //memoization
        arr[n] = dp(n-1) + 1; // 배열 초기화해서 넣어줌
        if(n%2 == 0) {
            int temp = dp(n/2) + 1;
            if(arr[n] > temp) arr[n] = temp; //좀 더 작은 경우의 수가 있는 경우 갱신
        }
        if(n%3 == 0) {
            int temp = dp(n/3) + 1;
            if(arr[n] > temp) arr[n] = temp;
        }
        return arr[n];
    }

}
