package com.hust.edu.cn.hashMap;

import java.util.HashMap;
import java.util.Map;

class _290 {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if (pattern.length() != s.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if (!map.containsKey(pattern.charAt(i)) && !map.containsValue(s[i]) || (map.containsKey(pattern.charAt(i)) && s[i].equals(map.get(pattern.charAt(i))))) {
                map.put(pattern.charAt(i), s[i]);
            } else {
                return false;
            }

        }
        return true;
    }
}
