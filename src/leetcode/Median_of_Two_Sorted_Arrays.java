/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Arrays;

/**
 * Created by youngjae.havi on 2019-02-22
 */
public class Median_of_Two_Sorted_Arrays {

    public static void main(String[] args) {
        int[] num1 = new int[]{3};
        int[] num2 = new int[]{-2,-1};

        System.out.println(solution(num1, num2));
    }

    private static double solution(int[] num1, int[] num2) {
        double midNum1 = calMid(num1);
        double midNum2 = calMid(num2);

        int index = num1.length == 0 || num2.length == 0 ? 1 : 2;
        return (midNum1 + midNum2) / index;
    }

    private static double calMid(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Arrays.stream(nums).mapToDouble(i -> i).sum() / 2;
    }
}
