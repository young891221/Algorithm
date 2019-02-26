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
        double[] num1 = new double[]{1,3,7};
        double[] num2 = new double[]{3};

        System.out.println(solution(num1, num2));
    }

    private static String solution(double[] num1, double[] num2) {
        double midNum1 = calMid(num1);
        double midNum2 = calMid(num2);

        return String.valueOf((midNum1 + midNum2) / 2);
    }

    private static double calMid(double[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Arrays.stream(nums).sum() / 2;
    }
}
