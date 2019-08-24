package DP;

import org.junit.Test;

public class _303 {
    private int[] data;

    @Test
    public void Test() {

    }

    public _303(int[] nums) {
        data = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            data[i + 1] = data[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return data[j + 1] - data[i];
    }
}
