package com.hust.edu.cn.math;

class _507 {
    public boolean checkPerfectNumber(int num) {
        if (num < 2) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += (i + num / i);
            }
        }
        return sum == num;
    }
}
