/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package org.lsz.leetcode;

import org.lsz.util.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liushuangzeng
 * @Date 20/6/7 上午9:12
 */
public class TowSum_1 {

    /**
     * 利用hash表的查询性能去做
     * time complexity: O(n)
     * space complexity: O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; ++i) {
            int another = target - nums[i];
            if (map.containsKey(another) && map.get(another) != i) {
                return new int[]{i, map.get(another)};
            }
        }
        return null;
    }

    /**
     * 与上解法基本一致，只是少遍历了一次数组
     * time complexity: O(n)
     * space complexity: O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int another = target - nums[i];
            if (map.containsKey(another)) {
                return new int[] {map.get(another), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TowSum_1 towSum = new TowSum_1();
        int[] a = new int[]{1, 2, 4, 5, 6};

        ArrayUtil.print(towSum.twoSum1(a, 10));
        ArrayUtil.print(towSum.twoSum2(a, 10));
    }
}