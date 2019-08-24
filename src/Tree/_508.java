package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _508 {
    private int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        sum(root, map);
        List<Integer> list = new ArrayList<>();
        for (Integer s : map.keySet()) {
            if (map.get(s) == max) {
                list.add(s);
            }
        }
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int sum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int left = sum(root.left, map);
        int right = sum(root.right, map);
        int s = root.val + left + right;
        if (map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
        max = Math.max(max, map.get(s));
        return s;
    }
}
