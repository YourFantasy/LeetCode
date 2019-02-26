package LinkedList;

import org.junit.Test;

public class _83 {
    @Test
    public void Test() {

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode phead = new ListNode(0);
        phead.next = head;
        ListNode p, pre;
        pre = phead;
        p = pre.next;
        while (p != null) {
            pre.next = p;
            pre = p;
            while (p.next != null && (p.next.val == p.val)) {
                p.next = p.next.next;
            }
            p = p.next;

        }
        return phead.next;
    }
}
