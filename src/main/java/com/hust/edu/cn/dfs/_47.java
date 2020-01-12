package com.hust.edu.cn.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class _47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, 0, nums.length - 1);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int begin, int end) {
        List<Integer> temp = new ArrayList<>();//临时存储数组中的元素
        if (begin == end) {
            for (int num : nums) {
                temp.add(num);
            }
            if (!res.contains(temp)) {
                res.add(temp);
            }
            return;
        }
        for (int i = begin; i <= end; i++) {
            if (i != begin && nums[i] == nums[begin]) {
                continue;
            }
            swap(i, begin, nums);
            dfs(nums, res, begin + 1, end);
            swap(i, begin, nums);//一次全排列完成后需要将数组还原，所以再进行一次交换
        }
    }

    private void swap(int i, int j, int[] nums) {//交换数组中的两个元素
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public List<List<Integer>> permuteUnique1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        while (true) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            res.add(temp);
            int i = nums.length - 1, j = nums.length - 1;
            for (; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    break;
                }
            }
            if (i > 0) {
                for (; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        break;
                    }
                }

                swap(i - 1, j, nums);
                reverse(nums, i, nums.length - 1);
            } else {
                break;
            }
        }
        return res;
    }

    public void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            swap(begin, end, nums);
            begin++;
            end--;
        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] pre = new boolean[nums.length];
        dfs2(nums, pre, res, new ArrayList<>());
        return res;
    }

    public void dfs2(int[] nums, boolean[] pre, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (pre[i]) {
                continue;
            }
            if (i == 0 || nums[i] != nums[i - 1] || pre
                    [i - 1]) {
                temp.add(nums[i]);
                pre[i] = true;
                dfs2(nums, pre, res, temp);
                pre[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
