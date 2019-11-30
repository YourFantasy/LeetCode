package Two_Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (target >= 0 && nums[i] > target || target < 0 && nums[i] >= 0) {
                return res;
            }
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < len - 2; j++) {
                    if (nums[j] > 0 && nums[j] + nums[i] >= target) {
                        return res;
                    }
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int low = j + 1, high = len - 1;
                        while (low < high) {
                            int sum = nums[i] + nums[j] + nums[high] + nums[low];
                            if (sum == target) {
                                List<Integer> temp = new ArrayList<>();
                                temp.add(nums[i]);
                                temp.add(nums[j]);
                                temp.add(nums[low]);
                                temp.add(nums[high]);
                                res.add(temp);
                                low++;
                                while (low < high && nums[low] == nums[low - 1]) {
                                    low++;
                                }
                                high--;
                                while (low < high && nums[high] == nums[high + 1]) {
                                    high--;
                                }
                            } else if (sum < target) {
                                low++;
                                while (low < high && nums[low] == nums[low - 1]) {
                                    low++;
                                }
                            } else {
                                high--;
                                while (low < high && nums[high] == nums[high + 1]) {
                                    high--;
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
