package com.hust.edu.cn.dp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _523 {


    /**
     * 解题思路：
     * 1.先判断k是否为0，如果k为0，在原数组中找到连续两个数为0，判断是否存在连续两个数为0，如果存在，返回true，如果不存在，返回false，因为数组元素是非负数，所以连续子数组之和可能的最小值为0（连续子数组所有元素都为0）
     * 2.如果k不为0，求数组的“取余前缀和”，此时数组中每个元素都比k小。用一个hashMap存储“取余前缀和”，key为和，value为index，如果存在相同元素，不覆盖，取第一个元素
     * 3.接下来就可以判断是否存在连续子数组和为k的倍数，如果该元素为0，显然说明存在连续子数组和为0（因为这个0是由0或者k的倍数取余数得到的），还有一种情况，熟悉前缀和的同学知道，两个前缀和的差，就是这两个位置之间元素的和，所以如果之前有相同的前缀和，并且这两个位置之间的元素个数大于等于2的话，说明存在连续子数组和为k的倍数
     */

    /**
     * 初始版
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum1(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        k = Math.abs(k);
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
            if (map.containsKey(nums[i]) && (i - map.get(nums[i])) >= 2) {
                return true;
            }
            if (k == 0) {
                if (nums[i] == 0 || (map.containsKey(nums[i]) && (i - map.get(nums[i])) >= 2)) {
                    return true;
                }
            } else {
                if (nums[i] % k == 0) {
                    return true;
                }
                int cnt = nums[i] / k;
                for (int j = 0; j <= cnt; j++) {
                    int left = nums[i] - k * j;
                    if (map.containsKey(left) && (i - map.get(left)) >= 2) {
                        return true;
                    }
                }
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }

        return false;
    }

    /**
     * 优化版
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum2(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int n = nums.length;
        if (k == 0) {
            for (int i = 1; i < n; i++) {
                if (nums[i] == nums[i - 1] && nums[i] == 0) {
                    return true;
                }

            }
            return false;
        }

        k = Math.abs(k);
        nums[0] %= k;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < n; i++) {
            nums[i] = (nums[i] + nums[i - 1]) % k;
            if (nums[i] == 0 || (map.containsKey(nums[i]) && (i - map.get(nums[i])) >= 2)) {
                return true;
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = {5, 2, 4, 0, 2};
        System.out.println(checkSubarraySum1(nums, 6));
        System.out.println(checkSubarraySum2(nums, 6));
    }
}
