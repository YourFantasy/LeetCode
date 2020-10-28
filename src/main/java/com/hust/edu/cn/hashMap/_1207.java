package com.hust.edu.cn.hashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>(arr.length * 4 / 3);
        for (int a : arr) {
            mp.put(a, mp.getOrDefault(a, 0) + 1);
        }
        return new HashSet<>(mp.values()).size() == mp.size();
    }
}
