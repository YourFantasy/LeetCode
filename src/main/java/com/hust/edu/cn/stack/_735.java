/**
 * @(#)_735.java, 1月 12, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.hust.edu.cn.stack;

import java.util.Stack;

/**
 * @author chenzhibj
 */
public class _735 {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty() || asteroid > 0 || asteroid * stack.peek() > 0) {
                stack.push(asteroid);
            } else {
                if (asteroid + stack.peek() == 0) {
                    stack.pop();
                    continue;
                }
                while (!stack.isEmpty() && stack.peek() > 0 && asteroid + stack.peek() < 0) {
                    stack.pop();
                }
                if (!stack.isEmpty() && asteroid + stack.peek() == 0) {
                    stack.pop();
                    continue;
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    /**
     * 数组简单栈，速度更快
     *
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision1(int[] asteroids) {
        int[] st = new int[asteroids.length];
        int index = -1;
        for (int asteroid : asteroids) {
            if (index < 0 || asteroid > 0 || asteroid * st[index] > 0) {
                st[++index] = asteroid;
            } else {
                if (st[index] + asteroid == 0) {
                    index--;
                    continue;
                }

                while (index >= 0 && st[index] > 0 && st[index] + asteroid < 0) {
                    index--;
                }

                if (index >= 0 && st[index] + asteroid == 0) {
                    index--;
                    continue;
                }

                if (index < 0 || st[index] < 0) {
                    st[++index] = asteroid;
                }
            }
        }
        int len = index + 1;
        int[] res = new int[len];
        System.arraycopy(st, 0, res, 0, len);
        return res;
    }
}