package com.hust.edu.cn.dfs;

class _980 {
    private int res = 0;

    public int uniquePathsIII(int[][] grid) {
        int x = -1, y = -1, cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != -1) {
                    cnt++;
                }
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    grid[i][j] = 0;
                }
            }
        }
        dfs(grid, 1, cnt, x, y);
        return res;
    }

    private void dfs(int[][] grid, int count, int cnt, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 2) {
            if (cnt == count) {
                res++;
            }
            return;
        }
        if (grid[i][j] != 0) {
            return;
        }
        grid[i][j] = 1;
        dfs(grid, count + 1, cnt, i + 1, j);
        dfs(grid, count + 1, cnt, i - 1, j);
        dfs(grid, count + 1, cnt, i, j + 1);
        dfs(grid, count + 1, cnt, i, j - 1);
        grid[i][j] = 0;
    }
}
