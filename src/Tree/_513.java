package Tree;

import java.util.LinkedList;
import java.util.Queue;

class _513 {
    public int findBottomLeftValue(TreeNode root) {
        int result = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int len = queue.size();
            result = queue.peek().val;
            for (int i = 0; i < len; i++) {
                TreeNode p = queue.poll();
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
        return result;
    }

}
