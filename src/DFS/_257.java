package DFS;
import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class _257 {
    private List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }
        List<String> left = binaryTreePaths(root.left);
        for (String s : left) {
            res.add(root.val + "->" + s);
        }
        List<String> right = binaryTreePaths(root.right);
        for (String s : right) {
            res.add(root.val + "->" + s);
        }
        return res;
    }

}
