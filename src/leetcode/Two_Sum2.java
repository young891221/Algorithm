import java.util.HashMap;
import java.util.Map;

public class Two_Sum2 {
    public static void main(String[] args) throws IllegalArgumentException {
        int[] result = new Solution().twoSum(new int[]{2,3,4}, 6);
        for (int i : result) {
            System.out.println(i);
        }
    }

    static class Solution {
        public int[] twoSum(int[] numbers, int target) throws IllegalArgumentException {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                int base = target - numbers[i];
                if (map.containsKey(base)) {
                    return new int[]{map.get(base)+1, i+1};
                }
                map.put(numbers[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }
}
