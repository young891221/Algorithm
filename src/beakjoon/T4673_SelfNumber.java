/**
 * Created by youngjae on 2016. 10. 9..
 */
public class T4673_SelfNumber {
    public static void main(String[] args) {
        boolean arr[] = new boolean[100000];

        for(int i = 1; i < 10000; i++) {
            //생성자가 있는것만 선택해서 값을 넣어주고 이후에는 값이 없는 것만 출력하기기
            arr[logic(i)] = true;
        }

        for(int i = 1; i <= 10000; i++) {
            if(!arr[i]) { System.out.println(i); }
        }
    }

    static int logic(int begin) {
        int result = begin;

        if(begin / 10000 != 0) {
            result += begin / 10000;
        }
        if(begin / 1000 != 0) {
            result += (begin / 1000 % 10);
        }
        if(begin / 100 != 0) {
            result += (begin / 100 % 10);
        }
        if(begin / 10 != 0) {
            result += (begin / 10 % 10);
        }
        if(begin / 1 != 0) {
            result += (begin % 10);
        }

        return result;
    }

}
