package DFS;

import java.util.ArrayList;
import java.util.List;

public class _78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        result.add(empty);
        for (int i = 0; i < nums.length; i++) {
            int len = result.size();
            for (int j = 0; j < len; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }
}
