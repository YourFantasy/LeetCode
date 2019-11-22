package Tree;

public class _701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root!=null){
            if (root.val>val){
                root.left=insertIntoBST(root.left,val);
            }
            else {
                root.right=insertIntoBST(root.right,val);
            }
            return root;
        }
        return new TreeNode(val);
    }
}

