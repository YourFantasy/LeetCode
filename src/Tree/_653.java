package Tree;

import java.util.ArrayList;
import java.util.List;

class _653 {
    private final List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        In_order(root);
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == k) {
                return true;
            } else if (nums[i] + nums[j] < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;

    }

    private void In_order(TreeNode root) {
        if (root != null) {
            In_order(root.left);
            list.add(root.val);
            In_order(root.right);
        }
    }
}
