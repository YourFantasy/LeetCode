package Tree;

class _100 {
    private boolean flag = true;

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                isSameTree(p.left, q.left);
                isSameTree(p.right, q.right);

            } else {
                flag = false;
            }
        } else if (p != null || q != null) {
            flag = false;
        }
        return flag;
    }
}
