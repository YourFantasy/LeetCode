package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {//考虑根节点出栈的时候栈空，但此时仅仅遍历完了左子树，但p=root.right不为空，继续遍历右子树
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.peek();
                result.add(p.val);
                stack.pop();
                p = p.right;
            }

        }
        return result;
    }


}
