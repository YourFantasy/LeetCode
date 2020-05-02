/**
 * @(#)_498.java, 5月 02, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.hust.edu.cn.array;

/**
 * @author chenzhibj
 */
public class _498 {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int i = 0, j = 0;
        for (int k = 0; k < res.length; k++) {
            res[k] = matrix[i][j];
            if ((i + j) % 2 == 0) {
                if (j == n - 1) {
                    i++;
                } else if (i == 0) {
                    j++;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i == m - 1) {
                    j++;
                } else if (j == 0) {
                    i++;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}