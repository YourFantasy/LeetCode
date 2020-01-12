package com.hust.edu.cn.linkedList;

public class _24 {

    public ListNode swapPairs(ListNode head) {
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode p = phead;
        while (p.next != null && p.next.next != null) {
            ListNode q1 = p.next;
            ListNode q2 = p.next.next;
            p.next = q2;
            q1.next = q2.next;
            q2.next = q1;
            p = q1;
        }
        return phead.next;
    }


    public ListNode swapPairs1(ListNode head) {

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p = pre;
        ListNode q = p.next;
        while (q != null && q.next != null) {
            ListNode temp = q.next;
            q.next = temp.next;
            temp.next = q;
            p.next = temp;
            p = q;
            q = p.next;
        }
        return pre.next;
    }
}
