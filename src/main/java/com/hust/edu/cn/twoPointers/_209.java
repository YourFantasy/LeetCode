package com.hust.edu.cn.twoPointers;

class _209 {
    //使用双指针实现滑动窗口，i始终指向满足sum>=s时左边元素，j是工作指针。i作为指向左边元素的指针，所以不能指向最后一个元素，不然sum为0。
    public int minSubArrayLen1(int s, int[] nums) {
        int res = nums.length + 1;
        int i = 0, j = 0;
        int sum = 0;
        while (i < nums.length - 1) {
            if (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            } else {
                sum -= nums[i];
                i++;
            }
            if (sum >= s) {
                res = Math.min(res, j - i);
            }

        }
        if (res < nums.length + 1) {
            return res;
        }
        return 0;
    }

    /**
     * 使用前缀和
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        if (nums[nums.length - 1] < s) {
            return 0;
        }
        int minLen = nums.length + 1;
        int i = -1, j = 0;
        while (i < j && j < nums.length) {
            int sub;
            if (i < 0) {
                sub = nums[j];
            } else {
                sub = nums[j] - nums[i];
            }
            if (sub >= s) {
                minLen = Math.min(minLen, j - i);
                i++;
            } else {
                j++;
            }
        }

        return minLen == nums.length + 1 ? 0 : minLen;
    }
}
