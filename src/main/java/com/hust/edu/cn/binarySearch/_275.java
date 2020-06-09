/**
 * @(#)_275.java, 6月 08, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.hust.edu.cn.binarySearch;

/**
 * @author chenzhibj
 */
public class _275 {

    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0, right = len - 1;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midNum = citations[mid];
            // midNum代表数字中间位置论文被引用的次数，该位置后面论文被引用次数都大于等于该论文的被引用次数，如果被引用次数大于等于论文篇数，说明该位置满足要求，继续向左边寻找，此时res=len-mid(论文篇数)，res动态变化，取最大的;否则说明该位置引用次数过少，需要向右边寻找。
            if (midNum >= len - mid) {
                right = mid - 1;
                res = Math.max(res, len - mid);
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}