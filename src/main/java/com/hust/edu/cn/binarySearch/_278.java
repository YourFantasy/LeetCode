package com.hust.edu.cn.binarySearch;

class _278 {
    public int firstBadVersion(int n) {
        int i = 1, j = n;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (!isBadVersion(mid)) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
