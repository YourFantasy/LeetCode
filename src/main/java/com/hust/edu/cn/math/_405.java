/**
 * @(#)_405.java, 3月 13, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.hust.edu.cn.math;

import org.junit.Test;

/**
 * @author chenzhibj
 */
public class _405 {

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        char ch;
        while (sb.length() < 8 && num != 0) {
            int cnt = num & 15;
            if (cnt <= 9) {
                ch = (char) ('0' + cnt);
            } else {
                ch = (char) ('a' + cnt - 10);
            }
            sb.append(ch);
            num >>= 4;
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(toHex(-1));
    }
}