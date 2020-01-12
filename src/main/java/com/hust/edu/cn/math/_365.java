package com.hust.edu.cn.math;

class _365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x + y + z == 0) {
            return true;
        }
        int m = get_divisor(x, y);
        return z % m == 0;
    }

    private int get_divisor(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        while (n > 0) {
            int by = m % n;
            m = n;
            n = by;
        }
        return m;
    }
}
