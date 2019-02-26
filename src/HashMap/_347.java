package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else
                map.put(nums[i], 1);
        }

        return res;

    }
}
