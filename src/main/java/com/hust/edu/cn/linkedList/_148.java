package com.hust.edu.cn.linkedList;

class _148 {
    private ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode first = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(first));
    }

    private ListNode merge(ListNode p1, ListNode p2) {
        ListNode tail = new ListNode(0);
        ListNode p = tail;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        p.next = (p1 == null) ? p2 : p1;
        return tail.next;
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head, q = head;
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        return p;
    }
}
