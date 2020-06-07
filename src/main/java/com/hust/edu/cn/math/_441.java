/**
 * @(#)_441.java, 6月 07, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.hust.edu.cn.math;

/**
 * @author chenzhibj
 */
public class _441 {

    /**
     * 数学公式解方程（一元二次方程求根公式）,注意越界问题
     *
     * @param n
     * @return
     */
    public int arrangeCoins1(int n) {
        long res = (long) (Math.sqrt((long) 2 * n + 0.25) - 0.5);
        return (int) res;
    }

    /**
     * 模拟台阶，因为第k级k个硬币，假设最多x层，则第x层为x个硬币，x层下面一层最多为x个硬币（因为如果是x+1或者更大，又可以新加一层台阶）
     *
     * @param n
     * @return
     */
    public int arrangeCoins2(int n) {
        int res = 0;
        while (n >= res) {
            n -= res;
            res++;
        }
        return res - 1;
    }

    /**
     * 二分查找法，找到最大的k，k最大不会超过(n+1)/2; 在1--(n+1)/2中间逼近，找到合适的k
     * 注意越界问题
     *
     * @param n
     * @return
     */
    public int arrangeCoins3(int n) {
        if (n <= 1) {
            return n;
        }
        long k = n;
        long left = 1, right = (k + 1) / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = mid * (mid + 1) / 2;
            if (sum == k) {
                return (int) mid;
            } else if (sum < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        if (left * (1 + left) / 2 > k) {
            return (int) (left - 1);
        } else {
            return (int) left;
        }
    }
}