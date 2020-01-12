/**
 * @(#)_945.java, 1月 12, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.hust.edu.cn.array;

/**
 * @author chenzhibj
 */
public class _945 {

    public int minIncrementForUnique(int[] A) {
        int res = 0;
        int n = A.length;
        int[] cnt = new int[n * 2];
        for (int i = 0; i < n; i++) {
            cnt[A[i]]++;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] <= 1) {
                continue;
            }
            res += cnt[i] - 1;
            cnt[i + 1] += cnt[i] - 1;
            cnt[i] = 1;
        }
        return res;
    }
}

