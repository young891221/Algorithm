import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * Created by youngjae on 2017. 5. 6..
 */
public class T11728_MergeSort {
    private static int[] a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        a = new int[n];
        b = new int[m];

        init(bf, n, a);
        init(bf, m, b);

        Integer[] merge = Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed()).sorted().toArray(Integer[]::new);
        Arrays.stream(merge).forEach(data -> System.out.print(data.intValue()+" "));
    }

    private static void init(BufferedReader bf, int n, int[] arr) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
