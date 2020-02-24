/**
 * @(#)_706.java, 2月 24, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.hust.edu.cn.design;

import java.util.Arrays;

/**
 * @author chenzhibj
 */
public class _706 {

    private int[] data;

    /**
     * Initialize your data structure here.
     */
    public _706() {
        this.data = new int[1000003];
        Arrays.fill(data, -1);
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        data[key] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return data[key];
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        data[key] = -1;
    }
}