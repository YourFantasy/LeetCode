package Tree;

import org.junit.Test;

import java.util.*;

public class _637 {
    @Test
    public void Test() {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(3);
        list.add(3);

        System.out.println(list.add(3));
        System.out.println(set.add(3));

        System.out.println(list.contains(3));
        System.out.println(set.contains(3));

        System.out.println(list);
        System.out.println(set);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            double temp = 0;
            for (int i = 0; i < num; i++) {
                TreeNode p = queue.poll();
                temp += p.val;
                if (p.left != null) {
                    queue.offer(p.left);
                }

                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            result.add(temp / num);
        }
        return result;
    }
}
