package Array;

import org.junit.Test;

import java.security.PublicKey;
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

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        //int target=nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1;
            if ((nums[i] > 0)||(nums[i]+nums[low])>0)
                return res;
            while (low < high) {
                List<Integer> temp = new ArrayList<>();
                int target = nums[i] + nums[low] + nums[high];
                if (target == 0) {
                    temp.add(nums[i]);
                    temp.add(nums[low]);
                    temp.add(nums[high]);
                    if (!res.contains(temp))
                        res.add(temp);
                    low++;
                    high--;
                    continue;
                } else if (target < 0)
                    low++;
                else
                    high--;

            }
        }
        return res;
    }
}
