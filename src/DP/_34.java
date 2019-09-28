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
        if (nums.length < 1 || (nums.length == 1 && nums[0] != target))
            return new int[]{-1, -1};
        int begin = find_left(nums, target);
        int end = find_right(nums, target);
        return new int[]{begin, end};
    }

    int find_left(int[] nums, int target) {
        int i = 0, j = nums.length - 1, begin = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int data = nums[mid];
            if (data == target) {
                begin = mid;
                j = mid - 1;
            } else if (data < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return begin;
    }

    int find_right(int[] nums, int target) {
        int i = 0, j = nums.length - 1, end = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int data = nums[mid];
            if (data == target) {
                end = mid;
                i = mid + 1;
            } else if (data < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return end;
    }
}
