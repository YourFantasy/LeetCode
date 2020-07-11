package com.hust.edu.cn.twoPointers;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _532 {

    public int findPairs1(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        if (k == 0) {
            for (int num : cnt.keySet()) {
                if (cnt.get(num) > 1) {
                    res++;
                }
            }
        } else {
            for (int num : cnt.keySet()) {
                if (cnt.containsKey(num + k)) {
                    res++;
                }
            }
        }
        return res;
    }


    public int findPairs2(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int cnt = 0;
        if (k == 0) {
            for (int num : map.keySet()) {
                int count = map.get(num);
                if (count > 1) {
                    cnt += count * (count - 1) / 2;
                }
            }
        } else {
            for (int num : map.keySet()) {
                if (map.containsKey(num + k)) {
                    cnt += map.get(num) * map.get(num + k);
                }
            }
        }
        return cnt;
    }

    @Test
    public void test() {
        int[] nums = {-1, 1, 1, 1, 3, 3, 3, 5, 5, 5, 7};
        int k = 0;
        System.out.println(findPairs1(nums, k));
        System.out.println(findPairs2(nums, k));
    }
}
