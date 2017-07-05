package codility.D20170610;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by KimYJ on 2017-06-10.
 * P[k-1] (2 <= K <= N)
 * 배열의 인덱스, 값이 같이 증가해야 된다.(값이 같아도 안됨!)
 * 이런식으로 해서 각기 다른 시퀀스의 개수를 구하는 것
 * 인덱스순의 순서쌍으로 모두 구하고 순서쌍별로 값을 비교
 */
public class Task4 {
    static List<int[]>[] list;

    public static void main(String[] args) {
        int[] A = new int[]{4, 6, 7, 3, 2, 7};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int n = factorial(A.length) / 2;
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        return 0;
    }

    public static int factorial(int num) {
        int result = 1;
        for (int i = num; i >= 1; i--)
            result *= i;
        return result;
    }

    /*private static List<int[]> firstLogic(int start, int length) {
        List<int[]> list = new ArrayList<>();
        for (int i = start; i < length-1; i++) {
                int[] arr = new int[]{start, i + 1};
                list.add(arr);
            }
        }

        return list;
    }*/

}
