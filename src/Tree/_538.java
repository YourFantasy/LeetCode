package Tree;

public class _538 {
    int sum = 0;

    /**
     * 逆向思维，二叉排序树，左根右遍历是有序的，反过来，右根左遍历是逆序的。
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            root.right = convertBST(root.right);
            sum += root.val;
            root.val = sum;
            root.left = convertBST(root.left);
            return root;
        }
        return null;
    }
}
