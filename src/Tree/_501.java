package Tree;

import java.util.ArrayList;
import java.util.List;

public class _501 {
    private TreeNode pre = null;
    private int max = 0, now = 1;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        // int[] result1 = res.stream().mapToInt(p -> p.intValue()).toArray();
        //int[] result2 = res.stream().mapToInt(Integer::intValue).toArray();
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;

    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorder(root.left, res);
            if (pre != null) {
                now = pre.val == root.val ? now + 1 : 1;
            }
            if (now == max) {
                res.add(root.val);
            }
            if (now > max) {
                res.clear();
                res.add(root.val);
                max = now;
            }
            pre = root;
            inorder(root.right, res);
        }
    }
}
