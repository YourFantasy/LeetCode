package com.hust.edu.cn.linkedList;

class _61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode phead = new ListNode(0);
        if (head == null || head.next == null) {
            return head;
        }
        int cnt = 0;
        phead.next = head;
        ListNode pre = phead;
        ListNode p = pre.next;
        while (p != null) {
            cnt++;
            pre = p;
            p = p.next;
        }
        pre.next = head;
        k = k % cnt;
        int count = 1;
        ListNode q = head;
        while (count < cnt - k) {
            count++;
            q = q.next;
        }
        ListNode m = q.next;
        q.next = null;
        return m;
    }
}
