package Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102 {
    @Test
    public void Test() {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList temp = new ArrayList();
        queue.offer(root);
        temp.add(root.val);
        result.add(temp);
        while (queue.size() > 0) {
            temp = new ArrayList();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode p = queue.poll();
                if (p.left != null) {
                    queue.offer(p.left);
                    temp.add(p.left.val);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                    temp.add(p.right.val);
                }
            }
            if (!temp.isEmpty())
                result.add(temp);
        }
        return result;
    }
}
