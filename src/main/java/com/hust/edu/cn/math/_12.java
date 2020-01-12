package com.hust.edu.cn.math;

import org.junit.Test;

public class _12 {
    @Test
    public void test() {
        System.out.println(intToRoman(159));
    }

    private String intToRoman(int num) {
        int[] digits = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder res = new StringBuilder();
//        for (int i=roman.length-1;i>=0;i--){
////            while (num>=digits[i]){
////                num-=digits[i];
////                res+=roman[i];
////            }
////        }
        int i=digits.length-1;
        while (num>0){
            int n=num/digits[i];
            for (int j=0;j<n;j++) {
                res.append(roman[i]);
            }
            num=num%digits[i];
            i--;
        }
        return res.toString();
    }
}
