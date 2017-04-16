import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by youngjae on 2017. 4. 16..
 * 1번째 줄 - 상근이가 갖고 있는 숫자 카드
 * 2번째 줄 - 숫자카드들의 숫자
 * 3번째 줄 - 체크해야 될 숫자들의 갯수
 * 4번째 줄 - 체크되어야 될 숫자들
 * 로직 - 2번까지 받고 소팅, 4번까지 받고 이분 탐색
 */
public class T10815_Number_BSearch {

    private static int cardTotal, checkTotal;
    private static int[] cardNumbers, checkNumbers, result;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        cardTotal = scan.nextInt();
        cardNumbers = new int[cardTotal];
        for(int i = 0; i < cardTotal; i++) {
            cardNumbers[i] = scan.nextInt();
        }
        Arrays.sort(cardNumbers);

        checkTotal = scan.nextInt();
        checkNumbers = new int[checkTotal];
        for(int i = 0; i < checkTotal; i++) {
            checkNumbers[i] = scan.nextInt();
        }

        result = new int[checkTotal];
        for(int i = 0; i < checkTotal; i++) {
            bSearch(i, 0, cardTotal - 1);
        }

        Arrays.stream(result).forEach(data -> System.out.print(data+" "));
        //test();
    }

    private static void bSearch(int order, int l, int r) {
        int x = checkNumbers[order];

        while (l <= r) {
            int m = (l + r) / 2;

            if (cardNumbers[m] == x) {
                result[order] = 1;
                break;
            } else if (cardNumbers[m] > x) {
                r = m - 1;
            } else if (cardNumbers[m] < x) {
                l = m + 1;
            }
        }
    }

    private static void test() {
        Arrays.stream(cardNumbers).forEach(data -> System.out.print(data+" "));
        System.out.println();
        Arrays.stream(checkNumbers).forEach(data -> System.out.print(data+" "));
    }
}
