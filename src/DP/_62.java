package DP;

import org.junit.Test;

import java.util.Scanner;

public class _62 {
    int total = 0;

    @Test
    public void Test() {
        Scanner input = new Scanner(System.in);
        /*int m = input.nextInt();
        int n = input.nextByte();*/
        int m = 7;
        int n = 5;
        System.out.println(uniquePaths(m, n));
        dfs(m - 1, n - 1);
        System.out.println(total);
    }


    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0)
            return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    //DFS 解法,超时
    public void dfs(int i, int j) {
        if (i >= 0 && j >= 0) {
            if (i == 0 && j == 0) {
                total++;
                return;
            }
            dfs(i - 1, j);
            dfs(i, j - 1);
        }
    }
}
