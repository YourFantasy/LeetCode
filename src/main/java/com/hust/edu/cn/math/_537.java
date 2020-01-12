package com.hust.edu.cn.math;

import org.junit.Test;

public class _537 {
    @Test
    public void test() {
        String s=complexNumberMultiply("1+-1i", "1+-1i");
        System.out.println(s);
    }

    private String complexNumberMultiply(String a, String b) {
        String result = "";
        String m = "";
        String n = "";
        m += (a.charAt(0) - '0') * (a.charAt(0) - '0') - (a.charAt(2) - '0') * (a.charAt(2) - '0');
        n += (a.charAt(0) - '0') * (a.charAt(2) - '0') + (a.charAt(0) - '0') * (a.charAt(2) - '0');
        result = m + n + "i";

        return result;
    }
}
