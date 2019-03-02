package DP;

import org.junit.Test;

public class _152 {
    @Test
    public void test() {
        int[] nums = {-2, 0, -1};
        System.out.print(maxProduct(nums));
    }

    //使用max和min分别表示数组中乘积的最大值和最小值，初始化为1，表示此时没有元素相乘。
    //如果当前的nums[i]为负数，此时min与max交换，因为当a<=b，c<0;a*c>=b*c。
    //
    public int maxProduct(int[] nums) {
        int Max = Integer.MIN_VALUE, max = 1, min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            Max = Math.max(max, Max);
        }
        return Max;
    }
}
