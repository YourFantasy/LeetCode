package com.hust.edu.cn.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 以(1,2,3,4)为例，开头为1的情况后面的所有三个数为(2,3,4),同理，继续以这三个数为一个数组进行全排列，所以f(n)=n*f(n-1),其中f(1)=1,这就构成了一个递归
 */
public class _46 {
    private int cnt = 0;

    @Test
    public void test() {
        int len = 5;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = (int) (Math.random() * 10);
            System.out.print(nums[i] + " ");
        }
        System.out.println(permute(nums));
        System.out.println(cnt);

    }

    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, 0, nums.length - 1);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int begin, int end) {
        //临时存储数组中的元素
        List<Integer> temp = new ArrayList<>();
        if (begin == end) {
            for (int num : nums) {
                temp.add(num);
            }
            if (!res.contains(temp)) {
                res.add(temp);
                cnt++;
            }
            return;
        }
        for (int i = begin; i <= end; i++) {
            if (i != begin) {
                //与待排列组合的数组的第一个元素交换
                swap(i, begin, nums);
            }
            dfs(nums, res, begin + 1, end);
            //一次全排列完成后需要将数组还原，所以再进行一次交换
            swap(i, begin, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {//交换数组中的两个元素
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
