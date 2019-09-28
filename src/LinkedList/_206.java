package LinkedList;

public class _206 {

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
