package Tree;

import java.util.*;

/**
 * @author YourFantasy
 * @date 2019-08-23 14:07
 * @description: 判断二叉树中的两个节点是否是堂兄弟节点
 */
public class _993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.left == null && root.right == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        queue.offer(root);
        map.put(root.val, 1);
        TreeNode p;
        while (!queue.isEmpty()) {
            int len = queue.size();
            boolean flag1 = false, flag2 = false;
            for (int i = 0; i < len; i++) {
                p = queue.poll();
                if (!flag1 && p.val == x) {
                    flag1 = true;
                }
                if (!flag2 && p.val == y) {
                    flag2 = true;
                }
                if (p.left != null) {
                    queue.offer(p.left);
                    map.put(p.left.val, map.get(p.val) * 2);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                    map.put(p.right.val, map.get(p.val) * 2 + 1);
                }
            }
            boolean flag = flag1 && flag2 && (Math.abs(map.get(x) - map.get(y)) != 1);
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
