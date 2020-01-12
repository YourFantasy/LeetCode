package com.hust.edu.cn.hashMap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YourFantasy
 * @date 2019/9/30 9:57 上午
 * @description: 和为K的子数组
 */
public class _560 {
    @Test
    public void test() {
        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int res1 = subarraySum1(nums, 0);
        int res2 = subarraySum2(nums, 0);
        System.out.println(res1);
        System.out.println(res2);

    }

    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        int res = 0;
        for (int i = 0; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (sum[j] - sum[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        Map<Integer, Integer> map = new HashMap<>(len * 2);
        for (int i = 0; i < len; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        int res = 0;
        for (int i = 0; i <= len; i++) {
            int sub = sum[i] - k;
            if (map.containsKey(sub)) {
                res += map.get(sub);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return res;
    }
}
