package com.hust.edu.cn.binarySearch;

class _240 {
    /**
     * 对每一行进行二分查找
     * 时间复杂度O(mlogn)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {

        int len = matrix.length;
        for (int[] ints : matrix) {
            int left = 0, right = ints.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target == ints[mid]) {
                    return true;
                } else if (target < ints[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    /**
     * 找到这样一个位置，该位置是该位置所在行最大的元素同时也是该位置所在列最小的元素
     * 分析：如果target==matrix[i][j] 直接返回
     * 如果target < matrix[i][j]，只能在该位置前一列寻找
     * 如果target>matrix[i][j],只能在该位置后一行寻找
     * 时间复杂的O(n+m)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
