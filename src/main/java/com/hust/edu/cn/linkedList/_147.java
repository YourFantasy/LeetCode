package com.hust.edu.cn.linkedList;

public class _147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pHead = new ListNode(0);
        ListNode preHead = pHead;
        preHead.next = head;
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode q = preHead.next;
        while (p != null) {
            /**
             * 做个判断，如果当前节点值大雨前一个节点，则已经排好序了，指针直接前进一步。
             */
            if (p.val >= pre.val) {
                pre = p;
                p = pre.next;
                continue;
            }
            while (q != p && q.val < p.val) {
                preHead = q;
                q = preHead.next;
            }
            if (q != p) {
                pre.next = p.next;
                p.next = preHead.next;
                preHead.next = p;
                p = pre.next;
            } else {
                pre = p;
                p = pre.next;
            }
            preHead = pHead;
            q = preHead.next;
        }
        return pHead.next;
    }
}
