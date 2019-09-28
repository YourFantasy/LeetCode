package Tree;

import java.util.ArrayList;
import java.util.List;

class _114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        for (int i = 0; i < list.size(); i++) {
            TreeNode p = list.get(i);
            if (i < list.size() - 1) {
                if (p.left != null) {
                    p.right = p.left;
                    p.left = null;
                } else if (p.right == null && p.left == null) {
                    p.right = list.get(i + 1);
                }
            } else {
                p.right = null;
                p.left = null;
            }
        }
    }

    private void preorder(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }
}
