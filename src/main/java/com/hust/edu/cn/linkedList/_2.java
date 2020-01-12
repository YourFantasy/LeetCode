package com.hust.edu.cn.linkedList;

public class _2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode result = new ListNode(0);
        ListNode p = result;
        int tmp = 0;
        while (p1 != null || p2 != null) {
            int val1 = (p1 == null) ? 0 : p1.val;
            int val2 = (p2 == null) ? 0 : p2.val;
            ListNode temp = new ListNode(0);
            temp.val = (val1 + val2 + tmp) % 10;
            tmp = (val1 + val2 + tmp) / 10;
            p.next = temp;
            p = temp;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }

        }

        if (tmp > 0) {
            ListNode temp = new ListNode(0);
            temp.val = tmp % 10;
            p.next = temp;
            p = temp;
        }
        return result.next;
    }


}
