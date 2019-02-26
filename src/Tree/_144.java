package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144 {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p;
        stack.push(root);
        while (stack.size() > 0) {
            p = stack.peek();
            result.add(p.val);
            stack.pop();
            if (p.right != null)
                stack.push(p.right);
            if (p.left != null)
                stack.push(p.left);

        }
        return result;
    }

}
