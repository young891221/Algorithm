package study;

import java.util.Stack;
import java.util.stream.IntStream;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString2("abcdefg"));
    }

    private static String reverseString(String target) {
        Stack stack = new Stack();
        StringBuilder builder = new StringBuilder();
        char arr[] = target.toCharArray();

        IntStream.range(0, arr.length).forEach(i -> stack.add(arr[i]));
        IntStream.range(0, arr.length).forEach(i -> builder.append(stack.pop()));

        return builder.toString();
    }

    private static String reverseString2(String target) {
        StringBuilder builder = new StringBuilder(target);
        return builder.reverse().toString();
    }
}
