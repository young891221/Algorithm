import java.util.Stack;

public class 문자열_뒤집기 {
    public static void main(String[] args) {
        System.out.println(reverseString("abcdefg"));
    }

    private static String reverseString(String target) {
        Stack stack = new Stack();
        StringBuilder builder = new StringBuilder();
        char arr[] = target.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            stack.add(arr[i]);
        }

        for(int i = 0; i < arr.length; i++) {
            builder.append(stack.pop());
        }

        return builder.toString();
    }
}
