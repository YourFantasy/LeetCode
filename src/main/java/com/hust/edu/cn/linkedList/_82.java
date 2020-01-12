package com.hust.edu.cn.linkedList;

class _82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode pre = phead;
        ListNode p = pre.next;
        while (p != null && p.next != null) {
            int target = p.val;
            boolean flag = false;
            while (p.next != null && p.next.val == target) {
                p = p.next;
                if (!flag) {
                    flag = true;
                }
            }
            if (flag) {
                pre.next = p.next;
                p = pre.next;
            } else {
                pre = p;
                p = p.next;
            }

        }
        return phead.next;
    }
}
