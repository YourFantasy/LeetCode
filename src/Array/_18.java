package Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18 {
    @Test
    public void test() {
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 20 - 10);
            System.out.print(nums[i] + ",");
        }
        System.out.println();
        List<List<Integer>> res = fourSum(nums, 0);
        System.out.println(res);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                int low = j + 1, high = len - 1;
                while (low < high) {
                    List<Integer> temp = new ArrayList<>();
                    int sum = nums[i] + nums[j] + nums[high] + nums[low];
                    if (sum == target) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        if (!res.contains(temp)) {
                            res.add(temp);
                        }
                        low++;
                        high--;
                        continue;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return res;
    }
}
