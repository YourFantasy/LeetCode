package com.hust.edu.cn.string;

import org.junit.Test;

public class _151 {
    @Test
    public void test() {
        System.out.println(reverseWords("a  good    example"));
    }

    private String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if(!"".equals(strs[i])){
                res.append(strs[i]);
                res.append(" ");
            }
        }
        return res.toString().trim();
    }
}
