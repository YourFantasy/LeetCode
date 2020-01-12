package com.hust.edu.cn.dfs;

class _52 {
    private int res = 0;

    public int totalNQueens(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n];
        search(0, n, nums);
        return res;
    }

    private void search(int n, int N, int[] nums) {
        if (n == N) {
            res++;
            return;
        }
        for (int i = 0; i < N; i++) {
            nums[n] = i;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (nums[n] == nums[j] || n - j == nums[n] - nums[j] || n - j == nums[j] - nums[n]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                search(n + 1, N, nums);
            }
        }
    }
}
