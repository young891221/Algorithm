package beakjoon;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by Administrator on 2016-10-17.
 */
public class Test {
    static boolean check[];
    static BigInteger arr[];
    static Map<BigInteger, BigInteger> map;
    static BigInteger N;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String n = scan.next();
        N = BigInteger.valueOf(Long.valueOf(n));
        map = new HashMap<>();
        System.out.println(dp(N).mod(BigInteger.valueOf(1000000)));
    }

    static BigInteger dp(BigInteger n) {
        if(n == BigInteger.ZERO) { return BigInteger.ZERO; }
        if(n == BigInteger.ONE) { return BigInteger.ONE; }
        if(map.get(n) != null) { return map.get(n); }
        dp(n);
        //map.put(n, dp(n.subtract(BigInteger.ONE)).add(dp(n.subtract(new BigInteger("2")))));

        return map.get(n);
    }
}
