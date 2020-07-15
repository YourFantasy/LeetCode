package com.hust.edu.cn.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 打家劫舍问题的变种
 * 1.对于一个指定的nums[i]，要么全选要么全不选，因为如果选了一个nums[i],则对nums[i]有威胁的（nums[i]-1,nums[i]+1）全部被干掉了，剩下的nums[i]都是可选的（因为能干掉nums[i]的只有nums[i]-1和nums[i]+1，这两个在第一次选nums[i]的时候已经被干掉了）
 * 2.因为对于任意的nums[i]的可选择性只有两种，要么全选，要么全不选，所以可以对nums[i]进行处理，求nums[i]的和，把这些和放到一个数组里，数组的索引是nums[i]，值为所有nums[i]之和，设数组为sum
 * 遍历sum数组，对于sum[i]来讲，只有两种可能性
 * 1.可以选sum[i]，则sum[i-1]没有被选（因为如果sum[i-1]被选了,sum[i]就被干掉了），sum[i-2]也可以选
 * 2.不能选sum[i]（被sum[i-1]干掉了），则sum[i-1]被选了，sum[i-2]也不能被选(被sum[i-1]干掉了)
 * <p>
 * 对于第一种可能性：收益为sum[i]+dp[i-2]
 * 对于第二种可能性：收益为dp[i-1]
 * 求两种选择的最大值，因为dp[i]只与dp[i-1]和dp[i-2]有关，所以可以优化dp数组为常量
 */
public class _740 {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxNum = nums[0];
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int[] sum = new int[maxNum + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[nums[i]] += nums[i];
        }
        int Ppre = 0, pre = sum[0];
        int res = Math.max(pre, Ppre + sum[1]);
        Ppre = pre;
        pre = res;
        for (int i = 2; i < sum.length; i++) {
            res = Math.max(Ppre + sum[i], pre);
            Ppre = pre;
            pre = res;
        }
        return res;
    }

    @Test
    public void test() {
        int n = 10;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (int) (Math.random() * 2 * n);
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(deleteAndEarn(nums));
    }
}
