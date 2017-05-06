import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by youngjae on 2017. 5. 5..
 * R개의 행, C개의 열
 * 열기준으로 잘라서 처음의 문자열은 똑같은 문자열이 없다.
 * 행을 잘르면서 문자열이 똑같지 않으면 Count를 1씩 증가시킴
 * 자르다가 문자열이 똑같아지면 종료
 * 로직
 * - 한번 중복되는 문자열은 위에 뭐가 추가되더라도 중복된다
 * - 중복되지 않는 문자열은 뭘 지우더라도 중복되지 않는다
 * 1)그러므로 처음에 입력 받은 문자를 기준으로 중복되는 문자열을 찾고 count를 바로 세버리기
 * 2)문자열을 열기준으로 잘라서 배열에 넣어놓고 정렬, 중복값 여부 검사
 */

/*
5 4
abcd
bbba
acbb
dcaa
ccbb
*/
public class T2866_SubString {
    private static int r, c, count = 0;
    private static String[] read, subInput;
    private static char[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        init(in);
        subStringByColumn();
        checkDulplicate();
    }

    private static void init(BufferedReader in) throws IOException {
        read = in.readLine().split(" ");
        r = Integer.parseInt(read[0]);
        c = Integer.parseInt(read[1]);
        input = new char[r][c];
        subInput = new String[c];

        for (int i = 0; i < r; i++) {
            String str = in.readLine();
            for (int j = 0; j < c; j++) {
                input[i][j] = str.charAt(j);
            }
        }
    }

    private static void subStringByColumn() {
        for (int j = 0; j < c; j++) {
            String temp = "";
            for (int i = 0; i < r; i++) {
                temp += String.valueOf(input[i][j]);
            }
            subInput[j] = temp;
        }
    }

    private static void checkDulplicate() {
        loop : for (int j = 0; j < c; j++) {
            Set<String> set = new LinkedHashSet<>();
            for (int i = 0; i < c; i++) {
                subInput[i] = subInput[i].substring(1);
                if (!set.contains(subInput[i])) set.add(subInput[i]);
                else {
                    System.out.println(count);
                    break loop;
                }
            }
            count++;
        }
    }

}
