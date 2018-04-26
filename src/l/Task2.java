import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 0 255 123 12 2 4 12 4 55 2
 * 5 0 3
 * 0 255 123 12 2 0 255 123 55 2
 * 0(src)부터 2(src+size-1)까지의 값들을 5(dest)부터 7(dest+size-1)까지 복사
 */
public class Task2 {

    private static final String REGEX = " ";
    private static int c;
    private static int[] v;
    private static int dest;
    private static int src;
    private static int size;

    public static void main(String[] args) throws IOException {
        input();
        memcpy(v, dest, src, size);
        Arrays.stream(v).forEach(i -> System.out.print(i+REGEX));
    }

    private static void memcpy(int[] v, int dest, int src, int size) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = src; i <= src+size-1; i++) {
            queue.add(v[i]);
        }

        for(int i = dest; i <= dest+size-1; i++) {
            v[i] = queue.remove();
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        c = Integer.parseInt(br.readLine());
        String arr[] = br.readLine().split(REGEX);
        v = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        String target[] = br.readLine().split(REGEX);
        dest = Integer.parseInt(target[0]);
        src = Integer.parseInt(target[1]);
        size = Integer.parseInt(target[2]);
    }
}
