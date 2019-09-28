package LinkedList;

class _203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode pre = phead;
        ListNode p = pre.next;
        while (p != null) {
            ListNode ptemp = p.next;
            if (p.val == val) {
                pre.next = p.next;
                p = ptemp;
            } else {
                pre = p;
                p = ptemp;
            }
        }
        return phead.next;
    }
}
