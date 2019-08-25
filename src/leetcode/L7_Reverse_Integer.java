/**
 * 첫 번쨰 솔루션
 * 1)마이너스 여부 확인 & 저장
 * 2)String 변환
 * 3)reverse by recursion
 * 4)0은 스킵
 * 5)마이너스 붙이고 to Integer
 * 접근: recursion
 * 공간: O(1)
 * 시간: O(n)
 */
public class L7_Reverse_Integer {
    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
    }
    static class Solution {

        public int reverse(int x) {
            String minus = x < 0 ? "-" : "";
            String reverseInt = minus;
            char[] chars = String.valueOf(x).replace("-", "").toCharArray();
            reverseInt = recursion(reverseInt, chars, chars.length - 1);
            int result = Integer.parseInt(reverseInt);

            int max = (int) Math.pow(2, 31);
            if ((int) Math.pow(-2, 31) >= result || result >= max) {
                return 0;
            }
            return result;
        }

        private String recursion(String reverseInt, char[] chars, int i) {
            if (i < 0) return reverseInt;
            if ("0".equals(chars[i]) || "-".equals(chars[i])) {
                return reverseInt;
            }
            reverseInt += chars[i];
            return recursion(reverseInt, chars, i -1);
        }

    }
}
