package Array;
import org.junit.Test;

import java.util.Arrays;

public class _16 {

    @Test
    public void Test() {

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target)
                    return sum;
                else if (sum < target)
                    low++;
                else
                    high--;
                if (Math.abs(result - target) > Math.abs(sum - target))
                    result = sum;
            }
        }
        return result;
    }
}
