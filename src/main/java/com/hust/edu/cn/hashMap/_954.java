package com.hust.edu.cn.hashMap;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YourFantasy
 * @date 2019/9/19 7:22 下午
 * @description: 二倍数对数组
 */
public class _954 {
    @Test
    public void test() {
        int[] A = {4, -2, 2, -4};
        boolean res = canReorderDoubled(A);
    }

    private boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : A) {
           map.put(value,map.getOrDefault(value,0)+1);
        }
        Arrays.sort(A);
        for (int value : A) {
            if (map.get(value) == 0) {
                continue;
            }
            if (value < 0) {
                if (value % 2 == 1) {
                    return false;
                } else {
                    if (!map.containsKey(value / 2) || map.get(value / 2) == 0) {
                        return false;
                    } else {
                        map.put(value, map.get(value) - 1);
                        map.put(value / 2, map.get(value / 2) - 1);

                    }
                }
            } else {
                if (!map.containsKey(value * 2) || map.get(value * 2) == 0) {
                    return false;
                } else {
                    map.put(value, map.get(value) - 1);
                    map.put(value * 2, map.get(value * 2) - 1);
                }
            }
        }
        for (Integer i : A) {
            if (map.get(i) != 0) {
                return false;
            }
        }
        return true;
    }
}
