package DP;

import org.junit.Test;

public class _63 {

    @Test
    public void Test() {
        int m = 7, n = 5;
        int[][] chess = new int[m][n];
        chess[2][1] = 1;
        chess[4][3] = 1;
        System.out.println(uniquePathsWithObstacles(chess));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    int up = (obstacleGrid[i - 1][j] == 1) ? 0 : dp[i - 1][j];
                    int left = (obstacleGrid[i][j - 1] == 1) ? 0 : dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                System.out.print(obstacleGrid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------");
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
