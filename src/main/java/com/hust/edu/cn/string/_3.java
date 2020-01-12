package com.hust.edu.cn.string;

import java.util.HashMap;

public class _3 {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                j = Math.max(j, map.get(ch));
            }
            ans = Math.max(ans, i - j + 1);
            map.put(ch, i + 1);
        }
        return ans;
    }
}
