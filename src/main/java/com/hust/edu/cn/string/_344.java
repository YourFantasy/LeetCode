package com.hust.edu.cn.string;

import org.junit.Test;

public class _344 {
    @Test
    public void Test() {
        String s = "Hello";
        System.out.println(reverseString(s));

    }

    private String reverseString(String s) {
        char[] ch = new char[s.length()];
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            ch[j++] = s.charAt(i);
        }

        return new String(ch);
    }
}
