import java.util.Scanner;

/**
 * Created by youngjae on 2017. 5. 5..
 * A: 하루 올라가는 거리
 * B: 밤에 내려오는 거리
 * V: 총 높이
 * 답: 꼭대기까지 몇일이 걸리나
 * 로직:
 */
public class T2869_Bsearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int v = scanner.nextInt();
        int target = 0;

        for(int i = 1; ;i++) {
            target += a;
            if(target >= v) {
                System.out.println(i);
                break;
            }
            target -= b;
        }
    }
}
