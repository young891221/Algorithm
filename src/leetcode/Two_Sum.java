import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2,3,4,}, 6)));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0, l = nums.length; i < l; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }
                map.put(nums[i], i); //map에 데이터를 캐싱하고 캐싱된 데이터 안에서 containsKey()로 확인(반대로)
            }

            throw new IllegalArgumentException("No two sum solution");
        }
    }
}
