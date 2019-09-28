package LinkedList;

class _86 {
    public ListNode partition(ListNode head, int x) {
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode pre1 = phead, pre2 = phead;
        ListNode p1 = pre1.next, p2 = pre2.next;
        while (p2 != null) {
            if (p1.val < x) {
                pre1 = p1;
                p1 = p1.next;
            } else {
                if (p2.val < x) {
                    pre1.next = p2;
                    pre2.next = p2.next;
                    pre1 = p2;
                    p2.next = p1;
                    p2 = pre2.next;
                    continue;
                }
            }
            pre2 = p2;
            p2 = p2.next;
        }
        return phead.next;
    }
}
