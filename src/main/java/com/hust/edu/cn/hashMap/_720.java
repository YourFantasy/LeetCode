package com.hust.edu.cn.hashMap;

import org.junit.Test;

import java.util.*;

public class _720 {
    /**
     * 暴力遍历法
     *
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        int maxLen = 0;
        String res = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < maxLen) {
                continue;
            }
            boolean flag = true;
            for (int j = words[i].length(); j > 0; j--) {
                String str = words[i].substring(0, j);
                if (!set.contains(str)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (maxLen < words[i].length()) {
                    res = words[i];
                    maxLen = words[i].length();
                } else if (maxLen == words[i].length() && sequence(words[i], res)) {
                    res = words[i];
                }
            }
        }
        return res;
    }


    boolean sequence(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return true;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                return false;
            }
        }
        return false;
    }

    /**
     * 利用String数组排序性质做
     *
     * @param words
     * @return
     */
    public String longestWord2(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";
        for (String str : words) {
            if (str.length() == 1 || set.contains(str.substring(0, str.length() - 1))) {
                res = str.length() > res.length() ? str : res;
                set.add(str);
            }
        }
        return res;
    }

    @Test
    public void test() {
        String[] words = {"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"};
        System.out.println(longestWord(words));
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        System.out.println(longestWord2(words));
    }
}
