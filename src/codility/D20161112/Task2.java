package codility.D20161112;

import java.util.Arrays;

/**
 * Created by KimYJ on 2016-11-12.
 */
public class Task2 {
    public static void main(String[] args) {
        int N = 1000000000;
        System.out.println(Arrays.toString(solution(N)));
    }

    public static int[] solution(int N) {
        if (N == 1 && N == 2 && N == 3 && N == 5 && N == 7) {
            return new int[]{};
        } else if(N % 2 == 0) {
            return new int[]{1, N - 1};
        } else {
            return new int[]{1, 3, N - 4};
        }
    }
}
