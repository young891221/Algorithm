package codility.D20171118;

public class Task2 {

    public static void main(String[] args) {
        int[] dates1 = { 1, 2, 4, 5, 7, 29, 30 };
        int[] dates2 = { 1,2,4,5,7,8,9,10,11,12,29,30 };
        int[] dates3 = { 1,2,4,5,7,8,9,10,12,29,30 };
        System.out.println(solution(dates1));
        System.out.println(solution(dates2));
        System.out.println(solution(dates3));
    }

    public static int dp(int index, int maxValue, int[] A) {
        if(index >= A.length) return 0;
        if(A[index] <= maxValue) return dp(index+1, maxValue, A);
        else return(Math.min(dp(index+1, A[index]+6, A)+7, dp(index+1, 0, A)+2));
    }

    public static int solution(int[] A) {
        if(A.length >= 23) return 25;
        else if(A.length <= 3) return A.length * 2;

        int value = Math.min(dp(1, A[0]+6, A)+7, dp(1, 0, A)+2);
        return Math.min(value, 25);
    }
}
