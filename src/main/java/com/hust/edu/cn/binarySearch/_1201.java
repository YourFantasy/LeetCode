package com.hust.edu.cn.binarySearch;

import org.junit.Test;

public class _1201 {

    public int nthUglyNumber(int n, int a, int b, int c) {
        // 最小公倍数
        long ab = (long) a * b / gcd(a, b), ac = (long) a * c / gcd(a, c), bc = (long) b * c / gcd(b, c), abc = ab * c / gcd(ab, c);
        long left = Math.min(a, Math.min(b, c));
        long right = left * n;
        while (left < right) {
            long m = left + (right - left) / 2;
            // 去重，补多删的,m/ab m/bc m/ac 删除了三个 m/abc ，所以要补一个m/abc
            long cnt = m / a + m / b + m / c + m / abc - m / ab - m / ac - m / bc;
            if (cnt < n) {
                left = m + 1;
            } else {
                right = m;
            }
        }

        return (int) left;
    }

    /**
     * m和n的最大公因数øø
     *
     * @param m
     * @param n
     * @return
     */
    private long gcd(long m, long n) {
        long a = Math.min(m, n);
        long b = Math.max(m, n);
        while (a > 0) {
            long temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

//    private long gcd(long m, long n) {
//        return m % n == 0 ? n : gcd(n, m % n);
//    }

    @Test
    public void test() {
        int n = 1000000000;
        int a = 2;
        int b = 217983653;
        int c = 336916467;
        System.out.println(nthUglyNumber(n, a, b, c));
    }
}
