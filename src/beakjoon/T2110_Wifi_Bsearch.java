import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by youngjae on 2016. 10. 8..
 * 답은 가장 인접한 공유기 사이의 거리
 * 1,2,4,8,9(3) = 3
 * 막약 2,4,6,10,12있고 3개의 공유기를 주면 = 답은 4
 * 모든 조건문에 대한 정의가 필요하고 그걸 어떻게 구현할지에 대해 고민해야 된다
 */
public class T2110_Wifi_Bsearch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = scan.nextInt();
        int arr[] = new int[n];
        int x = 0;
        int link = 1;

        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);

        while(true) {
            if(link != arr.length) { x = arr[link] - arr[0]; }
            if (check(arr, x, c)) {
                //c개를 골랐고 다음에 더 이상 없을 때
                System.out.println(x);
                break;
            }
            link++;
        }
    }

    static boolean check(int arr[], int x, int c) {
        boolean result = false;
        int imsiValue = 1;
        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j < i; j++) {
                if((i+1) != arr.length && arr[i] - arr[j] >= x) {
                    imsiValue++;
                    break;
                }
            }
        }

        if(imsiValue == c) { result = true; }

        return result;
    }
}
