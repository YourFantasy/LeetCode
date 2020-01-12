package com.hust.edu.cn.dfs;

import java.util.ArrayList;
import java.util.List;

class _78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        result.add(empty);
        for (int num : nums) {
            int len = result.size();
            for (int j = 0; j < len; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(num);
                result.add(temp);
            }
        }
        return result;
    }
}
