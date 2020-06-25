package com.hust.edu.cn.tree;

import java.util.ArrayList;
import java.util.List;

class _98 {
    /**
     * 自然的想法，将整棵二叉树中序遍历一遍，然后遍历最后的结果，如果不符合有升序，则代表不是一棵二叉搜索树
     * 时间复杂度 O(2*N)=O(N)
     * 空间复杂度O(N)
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        inorder(root, temp);
        for (int i = 1; i < temp.size(); i++) {
            if (temp.get(i) <= temp.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> temp) {
        if (root != null) {
            inorder(root.left, temp);
            temp.add(root.val);
            inorder(root.right, temp);
        }
    }

    /**
     * 优化版，其实不用遍历完整棵二叉树，在中序遍历二叉树的过程中，如果发现当前只要有一个节点的值小于前一个节点得值，此时说明该二叉树不是二叉搜索树。
     * preNodeVal代表当前节点的前一个节点的值，默认为Long.MIN_VALUE
     * 1.先判断左子树是否为二叉搜索树，如果不是，整棵树自然不是二叉搜索树，返回false
     * 2.如果左子树是二叉搜索树，判断当前节点是否小于前一个节点，如果是，让preNodeVal = root.val
     * 3.继续判断右子树是否是一棵二叉搜索树l
     * 时间复杂度 O(N/2)=O(N)
     * 空间复杂度O(1)
     */
    private long preNodeVal = Long.MIN_VALUE;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST2(root.left)) {
            if (preNodeVal < root.val) {
                preNodeVal = root.val;
                return isValidBST2(root.right);
            }
        }
        return false;
    }
}
