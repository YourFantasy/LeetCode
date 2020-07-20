package com.hust.edu.cn.linkedList;

public class _25 {
    public ListNode reverseKGroup1(ListNode head, int k) {
        int n = k;
        ListNode p = head, end = null;
        while (p != null && n != 0) {
            end = p;
            p = p.next;
            n--;
        }
        if (n != 0) {
            return head;
        }
        end.next = reverseKGroup1(end.next, k);
        while (head != end) {
            p = head;
            head = head.next;
            p.next = end.next;
            end.next = p;
        }
        return end;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        int cnt = 0;
        ListNode p = head, pre = null;
        while (p != null && cnt < k) {
            cnt++;
            pre = p;
            p = p.next;
        }
        if (cnt != k) {
            return head;
        }
        ListNode q = head;
        while (q != pre) {
            ListNode next = q.next;
            q.next = pre.next;
            pre.next = q;
            q = next;
        }

        head.next = reverseKGroup2(p, k);
        return pre;
    }

    public ListNode reverseKGroup3(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        int len = 0;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res, p = pre.next;
        while (p != null) {
            p = p.next;
            len++;
        }
        p = pre.next;
        for (int i = 0; i < len / k; i++) {
            ListNode next;
            for (int j = 0; j < k - 1; j++) {
                next = p.next;
                p.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = p;
            p = pre.next;
        }
        return res.next;
    }

}
