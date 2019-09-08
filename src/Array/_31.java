package Array;

import java.util.Arrays;

/**
 * @author YourFantasy
 * @date 2019/9/8 12:13 下午
 * @description: 下一个更大的排列
 */

/**
 * 基本思想：
 * 1、从后往前找，当找到某个数的前一个数比该数大，记该数前一个数为m，此时将该书后满部分进行排序
 * 2、在后面排好序的数组中找到一个比m大，此时和m交换，算法结束，return
 * 3、如果找不到下一个更大的排列，将数组排好序，此时最小
 */
public class _31 {
    public void nextPermutation(int[] nums) {
        for (int j = nums.length - 1; j > 0; j--) {
            if (nums[j] > nums[j - 1]) {
                Arrays.sort(nums, j, nums.length);
                for (int i = j; i < nums.length; i++) {
                    if (nums[j - 1] < nums[i]) {
                        int temp = nums[j - 1];
                        nums[j - 1] = nums[i];
                        nums[i] = temp;
                        return;
                    }
                }
            }

        }
        Arrays.sort(nums);
    }
}