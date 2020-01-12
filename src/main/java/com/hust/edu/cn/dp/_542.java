package com.hust.edu.cn.dp;

import org.junit.Test;

/**
 * @author YourFantasy
 * @date 2019/9/26 1:40 下午
 * @description: 01矩阵
 */
public class _542 {
    @Test
    public void test() {
        int m = 10, n = 5;
        int[][] matrix = new int[m][n];
        int[] data = {0, 1};
        int len = data.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = (int) (Math.random() * len);
                matrix[i][j] = data[index];
            }
        }
        updateMatrix(matrix);
    }

    private int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                dp[i][j] = row * column;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i < row - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j < column - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }

}
