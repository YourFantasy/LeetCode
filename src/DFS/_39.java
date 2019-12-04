package DFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39 {
    //condidates中的元素不能为0，不然递归无法终止
    @Test
    public void Test() {
        int[] nums = new int[16];
        for (int i = 0; i < 16; i++) {
            nums[i] = (int) (Math.random() * 20);
            if (nums[i] == 0) {
                nums[i] = i;
            }
        }

        combinationSum(nums, 12);

    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length < 1) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        dfs(result, temp, target, candidates, 0);
        System.out.println(result);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int target, int[] condidates, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            if (!result.contains(temp)) {
                result.add(new ArrayList<>(temp));
            }
            //result.add(temp);
            return;
        }
        for (int i = start; i < condidates.length; i++) {

            temp.add(condidates[i]);
            dfs(result, temp, target - condidates[i], condidates, i);
            if (temp.size() > 0) {
                temp.remove(temp.size() - 1);
            }
        }
    }


    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs1(candidates, res, new ArrayList<>(), 0, target);
        return res;
    }

    public void dfs1(int[] candidates, List<List<Integer>> res, List<Integer> temp, int begin, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = begin; i < candidates.length&&target>=candidates[i]; i++) {
            temp.add(candidates[i]);
            dfs1(candidates, res, temp, i, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
