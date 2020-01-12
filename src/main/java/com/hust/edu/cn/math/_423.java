package com.hust.edu.cn.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _423 {
    @Test
    public void test() {
        String s = "owoztneoer";
        System.out.println(originalDigits(s));
    }

    public String originalDigits(String s) {
        int[] cnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> res = new ArrayList<>();
        int count;
        boolean flag = true;
        while (flag) {
            if (cnt['z' - 'a'] > 0) {
                flag = false;
                count = cnt['z' - 'a'];
                for (int i = 0; i < count; i++) {
                    res.add(0);
                }
                cnt['e' - 'a'] -= count;
                cnt['r' - 'a'] -= count;
                cnt['z' - 'a'] -= count;
                cnt['o' - 'a'] -= count;
            }
            if (cnt['x' - 'a'] > 0) {
                flag = false;
                count = cnt['x' - 'a'];
                for (int i = 0; i < count; i++) {
                    res.add(6);
                }

                cnt['s' - 'a'] -= count;
                cnt['i' - 'a'] -= count;
                cnt['x' - 'a'] -= count;
            }
            if (cnt['u' - 'a'] > 0) {
                flag = false;
                count = cnt['u' - 'a'];
                for (int i = 0; i < count; i++) {
                    res.add(4);
                }

                cnt['u' - 'a'] -= count;
                cnt['f' - 'a'] -= count;
                cnt['o' - 'a'] -= count;
                cnt['r' - 'a'] -= count;
            }
            if (cnt['f' - 'a'] > 0) {
                flag = false;
                count = cnt['f' - 'a'];
                for (int i = 0; i < count; i++) {
                    res.add(5);
                }
                cnt['f' - 'a'] -= count;
                cnt['i' - 'a'] -= count;
                cnt['v' - 'a'] -= count;
                cnt['e' - 'a'] -= count;
            }
            if (cnt['g' - 'a'] > 0) {
                flag = false;
                count = cnt['g' - 'a'];
                for (int i = 0; i < count; i++) {
                    res.add(8);
                }


                cnt['g' - 'a'] -= count;
                cnt['e' - 'a'] -= count;
                cnt['i' - 'a'] -= count;
                cnt['h' - 'a'] -= count;
                cnt['t' - 'a'] -= count;
            }
            if (cnt['h' - 'a'] > 0) {
                flag = false;
                count = cnt['h' - 'a'];
                for (int i = 0; i < count; i++) {
                    res.add(3);
                }

                cnt['h' - 'a'] -= count;
                cnt['t' - 'a'] -= count;
                cnt['r' - 'a'] -= count;
                cnt['e' - 'a'] -= 2 * count;
            }
            if (cnt['s' - 'a'] > 0) {
                flag = false;
                count = cnt['s' - 'a'];
                for (int i = 0; i < count; i++) {
                    res.add(7);
                }

                cnt['s' - 'a'] -= count;
                cnt['e' - 'a'] -= 2 * count;
                cnt['v' - 'a'] -= count;
                cnt['n' - 'a'] -= count;
            }
            if (cnt['t' - 'a'] > 0) {
                flag = false;
                count = cnt['t' - 'a'];
                for (int i = 0; i < count; i++) {
                    res.add(2);
                }

                cnt['t' - 'a'] -= count;
                cnt['w' - 'a'] -= count;
                cnt['o' - 'a'] -= count;
            }
            if (cnt['o' - 'a'] > 0) {
                flag = false;
                count = cnt['o' - 'a'];
                for (int i = 0; i < count; i++) {
                    res.add(1);
                }

                cnt['o' - 'a'] -= count;
                cnt['n' - 'a'] -= count;
                cnt['e' - 'a'] -= count;
            }
            if (cnt['i' - 'a'] > 0) {
                flag = false;
                count = cnt['i' - 'a'];
                for (int i = 0; i < count; i++) {
                    res.add(9);
                }

                cnt['n' - 'a'] -= count;
                cnt['i' - 'a'] -= count;
                cnt['n' - 'a'] -= count;
                cnt['e' - 'a'] -= count;
            }

        }
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i));
        }
        return sb.toString();
    }

}
