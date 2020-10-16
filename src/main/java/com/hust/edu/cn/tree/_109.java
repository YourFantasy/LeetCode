package com.hust.edu.cn.tree;

import com.hust.edu.cn.linkedList.ListNode;

public class _109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode m = findMedium(head);
        TreeNode root = new TreeNode(m.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(m.next);
        return root;
    }

    private ListNode findMedium(ListNode head) {
        ListNode pre = head, p = pre.next, q = p.next;
        while (q != null && q.next != null) {
            pre = pre.next;
            p = pre.next;
            q = q.next.next;
        }
        pre.next = null;
        return p;
    }
}
