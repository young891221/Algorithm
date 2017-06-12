package codility.D20170610;

import java.util.Arrays;

/**
 * Created by KimYJ on 2017-06-10.
 * 배열에 주어지는 정수값들을 Pair(P,Q)일 경우 P~Q번째까지 곱셉하여 그 수치가 최대치인 값을 구하면 된다
 * DP문제
 * 주의 사항
 * - 최대곲이 1000000000.0보다 클 경우 1000000000.0를 반환
 * - 0 <= P <= Q < N
 */
public class Task2 {
    public static void main(String[] args) {
        double[] A = new double[]{1.0, 0.1, -1.0, -7.0, 3.0, -5.0, -2.5, 0.0, 1.0};
        System.out.println(solution(A));
    }

    public static double solution(double[] A) {
        double result = 0.0;
        result = dp(0, A, result);
        return result > 1000000000.0 ? 1000000000.0 : result;
    }

    private static double dp(int start, double[] A, double result) {
        for(int i = start; i < A.length; i++) {
            //dp(start+1, A, result) * dp(start+2, A, result);

            double same = A[i] * A[i];
            if(same > result) result = same;

            double subResult = A[i];
            for(int j = i+1; j < A.length; j++) {
                 subResult *= A[j];
                if(subResult > result) result = subResult;
            }
        }
        return result;
    }

    /*public static double solution(double[] A) {
        double result = 0.0;
        for(int i = 0; i < A.length; i++) {
            double same = A[i] * A[i];
            if(same > result) result = same;

            double subResult = A[i];
            for(int j = i+1; j < A.length; j++) {
                subResult *= A[j];
                if(subResult > result) result = subResult;
            }
        }
        return result;
    }*/
}
