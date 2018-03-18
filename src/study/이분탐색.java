import java.util.Arrays;

public class 이분탐색 {
    public static void main(String[] args) {
        int arr[] = new int[]{10,4,5,7,9,14,16};
        int target = 10;
        Arrays.sort(arr);

        System.out.println(bSearch(target, arr));
    }

    private static int bSearch(int target, int[] arr) {
        int first = 0;
        int last = arr.length;
        int mid;

        while (first <= last) {
            mid = (first + last) / 2;
            if(target == arr[mid]) {
                return mid;
            }
            else {
                if(target < arr[mid]) {
                    last = mid - 1;
                }
                else {
                    first = mid + 1;
                }
            }
        }

        return -1;
    }
}
