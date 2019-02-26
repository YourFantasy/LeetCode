package DFS;

import java.util.ArrayList;
import java.util.List;

public class _47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, 0, nums.length - 1);
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, int begin, int end) {
        List<Integer> temp = new ArrayList<>();//临时存储数组中的元素
        if (begin == end) {
            for (int i = 0; i < nums.length; i++)
                temp.add(nums[i]);
            if (!res.contains(temp))
                res.add(temp);
            return;
        }
        for (int i = begin; i <= end; i++) {
            if(i!=begin&&nums[i]==nums[begin])
                continue;
            swap(i, begin, nums);
            dfs(nums, res, begin + 1, end);
            swap(i, begin, nums);//一次全排列完成后需要将数组还原，所以再进行一次交换
        }
    }

    public void swap(int i, int j, int[] nums) {//交换数组中的两个元素
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
