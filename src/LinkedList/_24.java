package LinkedList;

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
}
