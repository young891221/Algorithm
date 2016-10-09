import java.util.*;
/**
 * Created by youngjae on 2016. 10. 9..
 */
public class T2110_Wifi_Bsearch_Good {

    public static boolean possible(int[] a, int c, int mid) {
        int cnt = 1;
        int last = a[0];
        for (int house : a) {
            if (house - last >= mid) { //mid(거리)는 마지막에 고른수보다 크거나 같아야 한다(point!!)
                cnt += 1;
                last = house;
            }
        }
        return cnt >= c;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int ans = 1; //사이의 거리(즉, x이자 답이다)
        int l = 1;
        int r = a[n - 1] - a[0];
        while (l <= r) { //r의 위치는 기본적으로 l보다 커야 하므로 같거나 커야 한다.(point!!)
            int mid = (l + r) / 2; //중간지점 구해서 2분하기(point!!)
            if (possible(a, c, mid)) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
