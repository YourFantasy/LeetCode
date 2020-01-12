package com.hust.edu.cn.dfs;

import java.util.ArrayList;
import java.util.List;

class _51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] nums = new int[n];
        search(res, 0, n, nums);
        return res;

    }

    private List<String> plan(int[] nums, int n) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == nums[i]) {
                    s.append("Q");
                } else {
                    s.append(".");
                }

            }
            temp.add(s.toString());

        }
        return temp;
    }

    private void search(List<List<String>> res, int n, int N, int[] nums) {
        if (n == N) {
            res.add(new ArrayList<>(plan(nums, N)));
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
                search(res, n + 1, N, nums);
            }
        }
    }
}
