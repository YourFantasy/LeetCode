package com.hust.edu.cn.array;

import org.junit.Test;

public class _643 {
    @Test
    public void Test() {
        int n = 10, k = 4;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (int) (Math.random() * 4 * n - 3 * n);
        }
        System.out.println(findMaxAverage1(nums, k));
        System.out.println(findMaxAverage2(nums, k));
    }

    /**
     * 暴力解法，超时
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage1(int[] nums, int k) {
        double result = Double.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            result = Math.max(result, (double) sum / k);
        }
        return result;
    }

    /**
     * 前缀和
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage2(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int sum, max = Integer.MIN_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            if (i == k - 1) {
                sum = nums[i];
            } else {
                sum = nums[i] - nums[i - k];
            }
            max = Math.max(max, sum);
        }

        return (double) max / k;

    }
}
