package beakjoon.bsearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by KimYJ on 2017-05-04.
 * 1번째 줄 - 상근이가 갖고 있는 숫자 카드 갯수
 * 2번째 줄 - 숫자카드들의 숫자들
 * 3번째 줄 - 주어지는 숫자 카드 갯수
 * 4번째 줄 - 체크되어야 될 숫자들
 * 로직
 * 1)2번까지 받고 소팅
 * 2)음수, 양수 각각의 갯수 배열에 미리 계산(마이너스의 경우 -data)
 * 3)4번까지 받고 이분 탐색
 */
public class T10816_Number_BSearch2 {
    private static final int MAX = 10000001;
    private static int cardTotal, checkTotal;
    private static int[] cardNumbers, checkNumbers, result, countMinusCard, countPlusCard;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        cardTotal = scan.nextInt();
        cardNumbers = new int[cardTotal];
        for(int i = 0; i < cardTotal; i++) {
            cardNumbers[i] = scan.nextInt();
        }
        Arrays.sort(cardNumbers);

        countMinusCard = new int[MAX];
        countPlusCard = new int[MAX];
        Arrays.stream(cardNumbers).forEach(data -> {
            if(data < 0) {
                countMinusCard[-data]++;
            } else {
                countPlusCard[data]++;
            }
        });

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
                if(x < 0) {
                    result[order] = countMinusCard[-x];
                } else {
                    result[order] = countPlusCard[x];
                }
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
