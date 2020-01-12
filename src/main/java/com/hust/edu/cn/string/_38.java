package com.hust.edu.cn.string;

import org.junit.Test;

public class _38 {
    @Test
    public void test() {
        System.out.println(countAndSay(6));
    }

    private String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            char tag = s.charAt(0);
            int cnt = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) != tag) {
                    temp.append(cnt);
                    temp.append(tag);
                    cnt = 1;
                    tag = s.charAt(j);
                } else {
                    cnt++;
                }
            }
            temp.append(cnt);
            temp.append(tag);
            s = temp.toString();
        }
        return s;
    }
}
