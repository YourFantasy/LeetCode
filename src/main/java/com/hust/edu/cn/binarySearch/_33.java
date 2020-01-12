package com.hust.edu.cn.binarySearch;

/**
 * 思路：1.判断nums[mid]落在哪个区域，是前面的区域还是后面的区域，经过旋转之后整个数组虽然不是有序的，但是两个区域内部还是有序的，并且我们可以得知数组第一个元素是前面区域里最小的，最后一个元素是后面区域里最大的，并且后面区域元素最大值小于前面区域元素的最大值。所以我们可以知道如果nums[mid] < nums[j]则nums[mid]一定是落在后面区域，相反一定是落在前面区域
 * 2.在各自的区域里进行二分查找
 */
class _33 {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[j]) {
                if (nums[mid] < target && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }

            } else {
                if (nums[mid] > target && target >= nums[i]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }
        return -1;
    }
}
