package Heap;

public class _215 {

    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int max = nums[i];
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                    index = j;
                }
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
        return nums[k - 1];
    }
}
