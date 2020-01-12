package com.hust.edu.cn.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class _145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        TreeNode q = null;
        TreeNode p;
        while (!stack.isEmpty()) {
            p = stack.peek();
            //如果该节点是叶子节点或该节点的孩子节点已经被访问，则访问该节点，并且将该节点出栈，更新被访问的节点，避免重复访问
            if ((p.left == null && p.right == null) || (q != null && (q == p.left || q == p.right))) {
                result.add(p.val);
                stack.pop();
                q = p;
            } else {
                if (p.right != null) {
                    //右子树不为空，右子树入栈
                    stack.push(p.right);
                }
                if (p.left != null) {
                    //左子树不为空，左子树入栈
                    stack.push(p.left);
                }

            }
        }
        return result;
    }

}
