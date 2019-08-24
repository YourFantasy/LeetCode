package Tree;

import java.util.ArrayList;
import java.util.List;

public class _98 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        inorder(root, temp);
        for (int i = 1; i < temp.size(); i++) {
            if (temp.get(i) <= temp.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode root, List<Integer> temp) {
        if (root != null) {
            inorder(root.left, temp);
            temp.add(root.val);
            inorder(root.right, temp);
        }
    }
}
