package com.hust.edu.cn.string;

import org.junit.Test;

public class _541 {
    @Test
    public void test() {
        String s = "abcd";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }

    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < s.length(); i += 2 * k) {
            if (len>= i + k) {
                sb.append(new StringBuilder(s.substring(i, i + k)).reverse());
            } else {
                sb.append(new StringBuilder(s.substring(i)).reverse());
                break;
            }
            if (i + 2 * k <= len) {
                sb.append(s, i + k, i + 2 * k);
            } else {
                sb.append(s.substring(i + k));
            }
        }
        return sb.toString();
    }

}
