package com.hust.edu.cn.tree;

class _230 {
    private int cnt=1;
    private int result;
    public int kthSmallest(TreeNode root, int k) {
        Inorder(root,k);
        return result;
    }
    private void Inorder(TreeNode root, int k){
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
