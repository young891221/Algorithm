package codility.D20161112;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by KimYJ on 2016-11-12.
 */
public class Task1_list {
    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 2, 5, 4, 4, 6, 3, 2};
        int[] B = new int[]{2, 1, 3, 2, 2, 3};
        System.out.println(solution(A));
        System.out.println(solution(B));
    }
    static public int solution(int[] A) {
        final int max = 2000002;
        int x = 1000000;
        int y = 1000000;
        int result = 0;
        Map<Integer, Boolean>[] map = new HashMap[max];
        for(int i = 0; i < max; i++) {
            map[i] = new HashMap<>();
        }

        loop : for(int i = 0, length = A.length; i < length; i++) {
            if(i%4 == 0) {
                for(int j = 0, p = y; j <= A[i]; j++, p++) {
                    if(j != 0 && map[x].get(p) != null && map[x].get(p)) {
                        result = i;
                        break loop;
                    } else {
                        map[x].put(p, true);
                        y = p;
                    }
                }
            } else if(i%4 == 1) {
                for(int j = 0, p = x; j <= A[i]; j++, p++) {
                    if(j != 0 && map[p].get(y) != null && map[p].get(y)) {
                        result = i;
                        break loop;
                    } else {
                        map[p].put(y, true);
                        x = p;
                    }
                }
            } else if(i%4 == 2) {
                for(int j = 0, p = y; j <= A[i]; j++, p--) {
                    if(j != 0 && map[x].get(p) != null && map[x].get(p)) {
                        result = i;
                        break loop;
                    } else {
                        map[x].put(p, true);
                        y = p;
                    }
                }
            } else if(i%4 == 3) {
                for(int j = 0, p = x; j <= A[i]; j++, p--) {
                    if(j != 0 && map[p].get(y) != null && map[p].get(y)) {
                        result = i;
                        break loop;
                    } else {
                        map[p].put(y, true);
                        x = p;
                    }
                }
            }

        }

        return result == 0 ? result : result+1;
    }
}
