package Tree;

public class _965 {
    boolean flag = true;

    public boolean isUnivalTree(TreeNode root) {
        int Target = root.val;
        Perse(root, Target);
        return flag;
    }

    public void Perse(TreeNode root, int target) {
        if (root != null) {
            if (root.val != target)
                flag = false;
            Perse(root.right, target);
            Perse(root.left, target);
        }
    }
}
