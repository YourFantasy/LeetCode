package com.hust.edu.cn.hashMap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _974 {
    public int subarraysDivByK1(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int cnt = 0;
        for (int j : A) {
            sum = ((sum + j) % K + K) % K;
            if (map.containsKey(sum)) {
                int temp = map.get(sum);
                cnt += temp;
                map.put(sum, temp + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return cnt;
    }

    public int subarraysDivByK2(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int j : A) {
            sum = (sum + j) % K;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        int cnt = 0;
        int v;
        for (int key : map.keySet()) {
            if ((v = map.get(key)) >= 2) {
                cnt += v * (v - 1) / 2;
            }
            if (map.containsKey(key + K)) {
                cnt += v * map.get(key + K);
            }
        }
        return cnt;
    }

    @Test
    public void test() {
        int[] nums = {4, 5, 0, -2, -3, 1};
        System.out.println(subarraysDivByK1(nums, 5));
        System.out.println(subarraysDivByK2(nums, 5));
    }
}
