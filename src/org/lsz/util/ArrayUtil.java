/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package org.lsz.util;

/**
 * @author liushuangzeng
 * @Date 20/6/7 上午9:30
 */
public class ArrayUtil {

    public static void print(int[] a) {
        if (a != null) {
            System.out.print("\n[");
            for (int i = 0; i < a.length - 1; ++i) {
                System.out.print(a[i] + ", ");
            }
            System.out.print(a[a.length - 1]);
            System.out.print("]\n");
        }
    }
}