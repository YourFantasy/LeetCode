package DP;

import org.junit.Test;

import java.util.Arrays;

public class _34 {
    @Test
    public void Test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums, 8);
        System.out.println(Arrays.toString(result));
    }

    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int len = 0, index = -1;
        int[] result;
        while (i < j) {
            int mid = (i + j) / 2;
            if (target == nums[mid]) {
                index = mid;
                break;
            } else if (target < nums[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        int start = index, end = index;
        if (index != -1) {
            if (index > 0) {
                start = i - 1;
                while (start >= 0 && nums[start] == target) {
                    start--;
                }

            }
        }

        if (index < nums.length - 1) {
            end = index + 1;

            while (end <= nums.length && nums[end] == target) {
                end++;
            }
            for (int k = start + 1; k < end;k++){
                
            }
        }

        return nums;
    }
}
