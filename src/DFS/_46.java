package DFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 以(1,2,3,4)为例，开头为1的情况后面的所有三个数为(2,3,4),同理，继续以这三个数为一个数组进行全排列，所以f(n)=n*f(n-1),其中f(1)=1,这就构成了一个递归
 */
public class _46 {
    private int cnt = 0;

    @Test
    public void test() {
        int len = 5;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = (int) (Math.random() * 10);
            System.out.print(nums[i] + " ");
        }
        System.out.println(permute(nums));
        System.out.println(cnt);

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, 0, nums.length - 1);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, int begin, int end) {
        List<Integer> temp = new ArrayList<>();//临时存储数组中的元素
        if (begin == end) {
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            if (!res.contains(temp)) {
                res.add(temp);
                cnt++;
            }
            return;
        }
        for (int i = begin; i <= end; i++) {
            if (i != begin) {
                swap(i, begin, nums);//与待排列组合的数组的第一个元素交换
            }
            dfs(nums, res, begin + 1, end);//交换过后与
            swap(i, begin, nums);//一次全排列完成后需要将数组还原，所以再进行一次交换
        }
    }

    public void swap(int i, int j, int[] nums) {//交换数组中的两个元素
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
