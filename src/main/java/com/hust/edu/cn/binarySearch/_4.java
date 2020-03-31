/**
 * @(#)_4.java, 3月 31, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.hust.edu.cn.binarySearch;

/**
 * @author chenzhibj
 */
public class _4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (isEmpty(nums1) && isEmpty(nums2)) {
            return 0.0;
        }
        if (isEmpty(nums1)) {
            return findEmptyMedian(nums2);
        }
        if (isEmpty(nums2)) {
            return findEmptyMedian(nums1);
        }
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            m = nums1.length;
            n = nums2.length;
        }
        int aMin = 0, aMax = m, midLen = (m + n + 1) / 2;
        while (aMin <= aMax) {
            int i = (aMin + aMax) / 2;
            int j = midLen - i;
            if (i < aMax && nums2[j - 1] > nums1[i]) {
                aMin = i + 1;
            } else if (i > aMin && nums1[i - 1] > nums2[j]) {
                aMax = i - 1;
            } else {
                int left;
                if (i == 0) {
                    left = nums2[j - 1];
                } else if (j == 0) {
                    left = nums1[i - 1];
                } else {
                    left = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return left;
                }
                int right;
                if (i == m) {
                    right = nums2[j];
                } else if (j == n) {
                    right = nums1[i];
                } else {
                    right = Math.min(nums1[i], nums2[j]);
                }
                return (left + right) / 2.0;
            }
        }
        return 0.0;
    }

    private double findEmptyMedian(int[] nums) {
        int len = nums.length;
        int mid = len / 2;
        if (len % 2 == 0) {
            return (nums[mid] + nums[mid - 1]) / 2.0;
        } else {
            return nums[mid];
        }
    }

    private boolean isEmpty(int[] A) {
        return A == null || A.length == 0;
    }
}