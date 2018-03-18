import java.util.Stack;
import java.util.stream.IntStream;

public class 문자열_뒤집기 {
    public static void main(String[] args) {
        System.out.println(reverseString("abcdefg"));
    }

    private static String reverseString(String target) {
        Stack stack = new Stack();
        StringBuilder builder = new StringBuilder();
        char arr[] = target.toCharArray();

        IntStream.range(0, arr.length).forEach(i -> stack.add(arr[i]));
        IntStream.range(0, arr.length).forEach(i -> builder.append(stack.pop()));

        return builder.toString();
    }
}
