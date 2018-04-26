import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr = input.split(" ");
        int horizontal = Integer.parseInt(arr[0]);
        int vertical = Integer.parseInt(arr[1]);

        //O(1)
        System.out.println(horizontal * vertical);
    }
}
