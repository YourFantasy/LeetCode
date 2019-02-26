package LinkedList;

import org.junit.Test;

public class _206 {
    @Test
    public void Test() {

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            ListNode tempnext = p.next;
            p.next = pre;
            pre = p;
            p = tempnext;
        }
        return pre;
    }
}
