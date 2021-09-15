package com.hust.edu.cn.hashMap;

import java.util.HashMap;
import java.util.Map;

public class _791 {
    public String customSortString(String order, String str) {
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            mp.put(str.charAt(i), mp.getOrDefault(str.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            if (mp.containsKey(order.charAt(i))) {
                for (int j = 0; j < mp.get(order.charAt(i)); j++) {
                    sb.append(order.charAt(i));
                }
                mp.put(order.charAt(i), 0);
            }
        }
        for (Character key : mp.keySet()) {
            if (mp.get(key) > 0) {
                for (int j = 0; j < mp.get(key); j++) {
                    sb.append(key);
                }
            }
        }
        return sb.toString();
    }

    public String customSortString1(String order, String str) {

        int[] index = new int[26];
        for (int i = 0; i < str.length(); i++) {
            index[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            int idx = order.charAt(i) - 'a';
            if (index[idx] > 0) {
                for (int j = 0; j < index[idx]; j++) {
                    sb.append(order.charAt(i));
                }
            }
            index[idx] = 0;
        }
        for (int i = 0; i < index.length; i++) {
            if (index[i] > 0) {
                for (int j = 0; j < index[i]; j++) {
                    sb.append((char) ('a' + i));
                }
            }
        }
        return sb.toString();
    }

}
