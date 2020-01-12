package com.hust.edu.cn.linkedList;

class _876 {
    public ListNode middleNode(ListNode head) {
        ListNode p = head, q = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        int middle = len / 2;
        while (middle > 0) {
            q = q.next;
            middle--;
        }
        return q;
    }
}
