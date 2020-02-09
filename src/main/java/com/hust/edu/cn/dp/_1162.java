/**
 * @(#)_1162.java, 2月 09, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.hust.edu.cn.dp;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chenzhibj
 */
public class _1162 {

    public int maxDistance(int[][] grid) {
        int res = -1;
        List<int[]> list = new LinkedList<>();
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }
        if (list.size() == row * col || list.size() == 0) {
            return res;
        }
        while (!list.isEmpty()) {
            res++;
            int num = list.size();
            while (num-- > 0) {
                int[] cur = list.remove(0);
                for (int[] d : dir) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        list.add(new int[]{x, y});
                    }
                }
            }
        }
        return res;
    }

    public int maxDistance1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        int maxDistance = m * n + 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                grid[i][j] = maxDistance;
                if (i > 0) {
                    grid[i][j] = Math.min(grid[i][j], grid[i - 1][j] + 1);
                }
                if (j > 0) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][j - 1] + 1);
                }

            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    continue;
                }
                if (i < m - 1) {
                    grid[i][j] = Math.min(grid[i][j], grid[i + 1][j] + 1);
                }
                if (j < n - 1) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][j + 1] + 1);
                }
                res = Math.max(res, grid[i][j]);
            }
        }

        return res == maxDistance ? -1 : res - 1;
    }
}