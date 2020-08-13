package com.hust.edu.cn.design;

import java.util.Random;

public class _384 {
    private int[] original;
    private int[] data;
    private Random random;

    public _384(int[] nums) {
        data = nums;
        original = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        random = new Random();
        for (int i = 0; i < data.length; i++) {
            swp(data, i, random.nextInt(data.length));
        }
        return data;
    }

    private void swp(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
