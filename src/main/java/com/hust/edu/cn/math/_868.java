package com.hust.edu.cn.math;

class _868 {
    public int binaryGap(int N) {
        int end = 0, begin = 0, cnt = 1, res = 0;
        while (N > 0) {
            if (N % 2 == 1) {
                if (begin != 0) {
                    begin = end;
                    end = cnt;
                } else {
                    begin = cnt;
                    end = cnt;
                }
            }
            res = Math.max(res, end - begin);
            N /= 2;
            cnt++;
        }
        return res;
    }
}
