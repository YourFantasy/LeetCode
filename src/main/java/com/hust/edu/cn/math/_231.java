package com.hust.edu.cn.math;

class _231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return n == (n & -n);
    }
}
