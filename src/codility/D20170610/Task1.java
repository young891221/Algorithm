package codility.D20170610;

/**
 * Created by KimYJ on 2017-06-10.
 * 앞, 기준, 뒤 => 기준을 중심으로 앞, 뒤의 수는 역수여야 한다(같아도 안된다)
 * 이런식으로 역수가 될 수 있는 가장 최고의 길이를 구하는 문제
 * DP로 돌면서 최대수를 구하는 문제(-10억 < A < 10억)
 */
public class Task1 {
    private static int result = 0;

    public static void main(String[] args) {
        int[] A = new int[]{5, 0, -2, 6, 3, 4, 4, -3, 5};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        try {
            dp(0, A);
        } catch (ArrayIndexOutOfBoundsException e) {
            return result;
        }
        return result;
    }

    static void dp(int start, int[] A) throws ArrayIndexOutOfBoundsException{
        int check = 0, subResult = 1;

        for(int i = start; i < A.length; i++) {
            if((A[i] == A[i+1]) || (check == 1 && A[i] < A[i+1]) || (check == -1 && A[i] > A[i+1])) {
                start++;
                break;
            }

            if(A[i] < A[i+1]) check = 1;
            else check = -1;

            subResult++;
            if(subResult > result) result = subResult;
        }
        if((start+1) != A.length) dp(start, A);
    }

}
