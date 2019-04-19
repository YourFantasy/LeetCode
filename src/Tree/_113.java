package Tree;

import java.util.ArrayList;
import java.util.List;

public class _113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res, temp, root, sum);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> temp, TreeNode root, int sum) {
        if (root == null)
            return;
        temp.add(root.val);
        if (root.left == null && root.right == null && sum == root.val)
            res.add(new ArrayList<>(temp));
        dfs(res, temp, root.left, sum - root.val);
        dfs(res, temp, root.right, sum - root.val);
        temp.remove(temp.size() - 1);
    }
}
