/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package org.lsz.leetcode;

/**
 * 最大连续子数组之和
 * @author liushuangzeng
 * @Date 20/6/8 上午9:12
 */
public class MaxSumForSubArray_42 {

    int[] array;

    public MaxSumForSubArray_42() {
        array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    }

    /**
     * 动态规划
     * 状态定义：
     *  dp[i]存储以nums[i]为结尾的连续子数组的最大和
     * 转移方程：
     *  dp[i] = {
     *      when dp[i-1] <= 0 then nums[i]
     *      when dp[i-1] > 0 then nums[i] + dp[i-1]
     *  }
     * time complexity: O(n)
     * space complexity: O(n)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] <= 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i-1] + nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 动态规划的简易写法
     * time complexity: O(n)
     * space complexity: O(1)
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + Math.max(nums[i-1], 0);
            max = Math.max(max, nums[i]);
        }
        return max;
    }

        public static void main(String[] args) {
        MaxSumForSubArray_42 sumForSubArray = new MaxSumForSubArray_42();
        System.out.println(sumForSubArray.maxSubArray(sumForSubArray.array));
    }
}