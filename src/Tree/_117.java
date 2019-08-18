package Tree;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class _117 {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            Node pre = queue.peek();
            if (pre.left != null)
                queue.offer(pre.left);
            if (pre.right != null)
                queue.offer(pre.right);
            queue.poll();
            for (int i = 1; i < len; i++) {
                Node p = queue.poll();
                if (p.left != null)
                    queue.offer(p.left);
                if (p.right != null)
                    queue.offer(p.right);
                pre.next = p;
                pre = p;
            }
            pre.next = null;
        }
        return root;
    }
}
