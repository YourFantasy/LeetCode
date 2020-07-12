package com.hust.edu.cn.dp;

public class _1139 {
    /**
     * 将正方形四条边命名为上下左右
     * 对于 grig[x][y]这个点，用down[x+1][y+1]表示以当前点作为右下角点的四边形下边的长度，用right[x+1][y+1]表示以当前点作为右下角点的四边形右边的长度。
     * 假设以该点作为正方形右下角有符合条件的正方形，那么该正方形可能的最大的边长为len=Math.min(down[x+1][y+1], right[x+1][y+1]);
     * 现在从该点逐渐"取正方形"（即该点向左和向右平移相同的单位，最多平移len长度),平移的过程中始终能够保证下边和右边满足全1
     * down[x+1 - len + 1][y+1]表示grid[x][y]向上平移len个单位，如果down[x+1 - len + 1][y+1]>=len，说明此时上边满足全1，同理right[x+1][y+1 - len + 1] >= len，说明此时左边满足全1，此时上下左右全满足全1，符合正方形的条件，此时正方形的边长为平移的长度
     *
     * @param grid
     * @return
     */
    public int largest1BorderedSquare(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] down = new int[m + 1][n + 1];
        int[][] right = new int[m + 1][n + 1];
        int maxLen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    down[i][j] = down[i][j - 1] + 1;
                    right[i][j] = right[i - 1][j] + 1;
                    int size = Math.min(down[i][j], right[i][j]);
                    if (size <= maxLen) {
                        continue;
                    }
                    for (int len = size; len >= 1; len--) {
                        if (down[i - len + 1][j] >= len && right[i][j - len + 1] >= len) {
                            maxLen = Math.max(maxLen, len);
                            break;
                        }
                    }

                }
            }
        }
        return maxLen * maxLen;
    }
}
