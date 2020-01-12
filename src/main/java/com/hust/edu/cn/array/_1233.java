package com.hust.edu.cn.array;

import org.junit.Test;

import java.util.*;

public class _1233 {
    @Test
    public void test() {
        String[] folder = {"/a/b/c", "/a/b/ca", "/a/b/d"};
        System.out.println(removeSubfolders(folder));

    }

    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < folder.length; i++) {
            map.put(folder[i], i);
        }
        for (int i = 0; i < folder.length; i++) {
            int len = folder[i].length();
            boolean flag = true;
            for (int j = len - 1; j > 1; j--) {
                if (folder[i].charAt(j) == '/' && map.containsKey(folder[i].substring(0, j))) {
                    flag = false;
                }
            }
            if (flag) {
                res.add(folder[i]);
            }
        }
        return res;
    }
}
