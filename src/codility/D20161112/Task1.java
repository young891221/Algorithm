package codility.D20161112;
import java.util.*;

/**
 * Created by KimYJ on 2016-11-12.
 */
public class Task1 {
    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 2, 5, 4, 4, 6, 3, 2};
        int[] B = new int[]{2, 1, 3, 2, 2, 3};
        System.out.println(solution(A));
        System.out.println(solution(B));
    }
    static public int solution(int[] A) {
        final int max = 20000;
        final int basic = 1000000;
        boolean node[][] = new boolean[max][max];
        int x = 1000000;
        int y = 1000000;
        int result = 0;

        for(int i = 0, length = A.length; i < length; i++) {
            A[i] += basic;
            if(i%4 == 0) {
                for(int j = y; j <= A[i]; j++) {
                    if(node[x][j] == true) {
                        result = i;
                        break;
                    }
                    y = A[i];
                    node[x][j] = true;
                }
            }else if(i%4 == 1) {
                for(int j = x; j <= A[i]; j++) {
                    if(node[j][y] == true) {
                        result = i;
                        break;
                    }
                    x = A[i];
                    node[j][y] = true;
                }
            }else if(i%4 == 2) {
                for(int j = y; j <= A[i]; j--) {
                    if(node[x][j] == true) {
                        result = i;
                        break;
                    }
                    y = A[i];
                    node[x][j] = true;
                }
            }else if(i%4 == 3) {
                for(int j = x; j <= A[i]; j--) {
                    if(node[j][y] == true) {
                        result = i;
                        break;
                    }
                    x = A[i];
                    node[j][y] = true;
                }
            }

        }

        return result+1;
    }
}
