package Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {
    @Test
    public void test() {
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 20 - 10);
            System.out.print(nums[i] + ",");
        }
        System.out.println();
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                return res;
            if (i == 0 || nums[i] != nums[i - 1]) {
                int begin = i + 1, end = nums.length - 1;
                while (begin < end) {
                    if (nums[i] + nums[begin] > 0) {
                        return res;
                    }
                    if (nums[begin] + nums[end] == -nums[i]) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[begin]);
                        temp.add(nums[end]);
                        res.add(temp);
                        begin++;
                        end--;
                        while (begin < end && nums[begin] == nums[begin - 1]) {
                            begin++;
                        }
                        while (begin < end && nums[end] == nums[end + 1]) {
                            end--;
                        }

                    } else if (nums[begin] + nums[end] < -nums[i]) {
                        begin++;
                        while (begin < end && nums[begin] == nums[begin - 1]) {
                            begin++;
                        }

                    } else {
                        end--;
                        while (begin < end && nums[end] == nums[end + 1]) {
                            end--;
                        }

                    }
                }
            }
        }
        return res;
    }
}
