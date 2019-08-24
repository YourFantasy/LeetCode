package Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _66 {
    @Test
    public void Test() {
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = (int) (Math.random() * 10);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
        plusOne(nums);
        int[] res=plusOne(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ",");
        }
    }

    public int[] plusOne(int[] digits) {
        List<Integer> temp = new ArrayList<>();
        int cnt = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            temp.add((digits[i] + cnt) % 10);
            cnt = (digits[i] + cnt) / 10;
        }
        if (cnt > 0) {
            temp.add(cnt);
        }
        int[] result = new int[temp.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[result.length - 1-i] = temp.get(i);
        }
        return result;
    }
}
