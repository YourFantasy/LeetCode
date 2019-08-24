package Tree;

public class _230 {
    int cnt=1,result;
    public int kthSmallest(TreeNode root, int k) {
        Inorder(root,k);
        return result;
    }
    public void Inorder(TreeNode root,int k){
        if(root!=null){
            Inorder(root.left,k);
            if(cnt==k) {
                result=root.val;
            }
            cnt++;
            Inorder(root.right,k);
        }
    }
}
