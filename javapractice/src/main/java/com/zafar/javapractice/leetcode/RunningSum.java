package com.zafar.javapractice.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class RunningSum {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int[] runningSumOfArray = runningSum(nums);
        for (int j : runningSumOfArray) {
            System.out.println(j);
        }
        System.out.println("Running sum = " + Collections.singletonList(runningSumOfArray).toString());
    }

    private static int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        if (nums.length > 1) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                runningSum[i] = sum;
            }
            return runningSum;
        } else {
            return nums;
        }

    }
}
