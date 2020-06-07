/**
 * @(#)_605.java, 6月 07, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.hust.edu.cn.array;

/**
 * @author chenzhibj
 */
public class _605 {

    /**
     * 如果要种花，必须满足该位置左右都没种花--->>有连续三个位置没有种花，对于第一个和最后一个位置，第一个位置左边可以认为没有种花，最后一个位置右边可以认为没有种花。
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 第一个位置左边默认没有种花，所以初始notFloweredCount为1
        int maxNum = 0, notFloweredCount = 1;
        for (int flower : flowerbed) {
            // 该位置已经种花了，之前的连续没种花无用了，此时notFloweredCount变成了0
            if (flower != 0) {
                notFloweredCount = 0;
            } else {
                notFloweredCount++;
            }
            // 连续三个位置没有种花，此时可以把花种在这三个位置的中间，此时该位置右边空出，所以notFloweredCount=1
            if (notFloweredCount == 3) {
                maxNum++;
                notFloweredCount = 1;
            }
        }
        // 如果最后连续有两个位置没有种花（倒数第一个和倒数第二个位置），此时可以把花种在最后一个位置
        if (notFloweredCount == 2) {
            maxNum++;
        }
        return n <= maxNum;
    }
}