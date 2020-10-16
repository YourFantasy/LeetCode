package com.hust.edu.cn.binarySearch;

public class _1095 {
    interface MountainArray {
        int get(int index);

        int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int index = findPeek(mountainArr);
        int left = binarySearch(mountainArr, target, 0, index, true);
        if (left != -1) {
            return left;
        }
        return binarySearch(mountainArr, target, index, mountainArr.length() - 1, false);
    }

    private int binarySearch(MountainArray mountainArr, int target, int i, int j, boolean isLeft) {
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (mountainArr.get(m) == target) {
                return m;
            } else if (mountainArr.get(m) < target) {
                if (isLeft) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            } else {
                if (isLeft) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            }
        }
        return -1;
    }

    private int findPeek(MountainArray mountainArr) {
        int i = 0, j = mountainArr.length() - 1;
        while (i < j) {
            int m = i + (j - i) / 2;
            if (mountainArr.get(m) > mountainArr.get(m + 1)) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}
