/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package org.lsz.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 求出最长的不包含重复元素的子串
 * @author liushuangzeng
 * @Date 20/6/7 上午10:11
 */
public class LongestSubstring_3 {

    String str;

    public LongestSubstring_3() {
        str = "abcabcbb";
//        str = " ";
    }

    /**
     * 暴力解法，双循环
     * time complexity: O(n^2)
     * space complexity: O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int k = 0; k < s.length(); ++k) {
            for (int i = k; i < s.length(); ++i) {
                if (!map.containsKey(String.valueOf(s.charAt(i)))) {
                    map.put(String.valueOf(s.charAt(i)), i);
                } else {
                    break;
                }
            }
            max = max < map.size() ? map.size() : max;
            map.clear();
        }
        return max;
    }

    /**
     * pwwkewsss
     * 滑动窗口，挨个删除
     * time complexity: O(n)
     * space complexity: O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 1;
        int max = 1;

        set.add(s.charAt(start));

        while (end < s.length()) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
            }
            max = Math.max(max, end - start);
        }

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                int i = start;
                start = map.get(s.charAt(end)) + 1;
                while (i < start) {
                    map.remove(s.charAt(i++));
                }
            }
            map.put(s.charAt(end), end++);
            max = Math.max(max, map.size());
        }
        return max;
    }

    /**
     * 滑动窗口，简易写法
     * abcabcbb
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

        public static void main(String[] args) {
        LongestSubstring_3 longestSubstring = new LongestSubstring_3();
        System.out.println(longestSubstring.lengthOfLongestSubstring(longestSubstring.str));
        System.out.println(longestSubstring.lengthOfLongestSubstring1(longestSubstring.str));
        System.out.println(longestSubstring.lengthOfLongestSubstring2(longestSubstring.str));
        System.out.println(longestSubstring.lengthOfLongestSubstring3(longestSubstring.str));
    }
}

