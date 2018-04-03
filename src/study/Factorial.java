public class Factorial {
    public static void main(String[] args) {
        int input = 4;
        System.out.println(fact(input));
    }

    private static int fact(int input) {
        if(input <= 1)
            return input;
        else
            return fact(input-1) * input;
    }
}
