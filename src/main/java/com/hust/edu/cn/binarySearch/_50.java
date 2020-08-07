package com.hust.edu.cn.binarySearch;

public class _50 {
    public double myPow(double x, int n) {
        int i = n;
        double res = 1;
        while (i != 0) {
            // 如果i为奇数，说明乘的过程中有损失，损失部分刚好为x
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
            i /= 2;
        }
        return n < 0 ? 1 / res : res;
    }
}
