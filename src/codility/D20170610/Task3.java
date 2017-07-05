package codility.D20170610;

/**
 * Created by KimYJ on 2017-06-10.
 * 최단경로, 가중치는 없음
 * 값이 1인 곳에는 멈충수가 없다
 * 한번 움직이면 다른 방향으로 2번
 * 2번 움직이면 다른 방향으로 1번
 * 무조건 왼쪽 위에서 오른쪽 아래로 이동하는 최소 회전 수 구하기(갈 수 없으면 -1 반환)
 */
public class Task3 {
    public static void main(String[] args) {
        int[][] A = new int[][]{};
        A[0][0] = 0;  A[0][1] = 0;  A[0][2] = 0;
        A[1][0] = 0;  A[1][1] = 0;  A[1][2] = 1;
        A[2][0] = 1;  A[2][1] = 0;  A[2][2] = 0;
        A[3][0] = 0;  A[3][1] = 0;  A[3][2] = 0;
        System.out.println(solution(A));
    }

    public static int solution(int[][] A) {
        return 0;
    }
}
