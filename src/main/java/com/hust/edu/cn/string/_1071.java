/**
 * @(#)_1071.java, 3月 09, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.hust.edu.cn.string;

/**
 * @author chenzhibj
 */
public class _1071 {

    public String gcdOfStrings(String str1, String str2) {
        if ((str1 + str2).equals(str2 + str1)) {
            return str2.substring(0, division(str1.length(), str2.length()));
        }
        return "";
    }

    public int division(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }

}