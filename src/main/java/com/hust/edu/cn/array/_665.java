package com.hust.edu.cn.array;

import org.junit.Test;

/**
 * @author YourFantasy
 * @date 2019/9/29 10:06 上午
 * @description: 非递减数组
 */
public class _665 {
    @Test
    public void test() {
        int[] nums = {3, 2, 3, 2, 4};
        System.out.println(checkPossibility(nums));
    }

    public boolean checkPossibility(int[] nums) {
        int len = nums.length;

        int index1 = 0;
        boolean flag1 = true;
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                index1 = i;
                break;
            }
        }
        if (index1 == 0 || index1 == len - 1) {
            return true;
        }
        if (nums[index1 + 1] < nums[index1 - 1]) {
            flag1 = false;
        } else {
            for (int i = index1 + 1; i < len - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    flag1 = false;
                    break;
                }
            }
        }
        int index2 = len - 1;
        boolean flag2 = true;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                index2 = i;
                break;
            }
        }
        if (index2 == 0 || index2 == len - 1) {
            return true;
        }

        if (nums[index2 + 1] < nums[index2 - 1]) {
            flag2 = false;
        } else {
            for (int i = index2 - 1; i > 0; i--) {
                if (nums[i] < nums[i - 1]) {
                    flag2 = false;
                    break;
                }
            }
        }
        return flag1 || flag2;
    }
}
