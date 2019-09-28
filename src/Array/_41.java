package Array;

import org.junit.Test;

public class _41 {
    @Test
    public void test() {
        int len = 10;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = (int) (Math.random() * len - len / 2);
            System.out.print(nums[i] + ",");
        }
        System.out.println();
        System.out.println(firstMissingPositive(nums));
    }
    /**
     * 核心思想，对于长度为n的数组来说，缺失的最小正数一定在1----n之间
     * 将每个符合值在1---n之间的数组元素放到对应的位置上去 (3放到索引为2，5放到索引为4..)
     * 如果对应的位置上已经有符合的元素了(数组存在重复的元素)，则不必发生交换
     * 在经过一系列操作之后数组元素的值在1---n之间的元素至少有一个放在了对应的位置上,并且是单调递增的
     * 遍历一遍数组，找到第一个不满足num[i]==i+1的位置，该位置即为要找的最小值，如果数组元素每个位置都满足nums[i]==i+1，说明此时数组的元素为(1,2,3,....n)，显然此时"缺失"的值为n+1；
     *
     * @param nums
     * @return
     */
    private int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int i = 0;
        while (i < len) {
            if (nums[i] == i + 1) {
                i++;
            }
            if (i < len && nums[i] >= 1 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < len; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return len + 1;
    }
}
