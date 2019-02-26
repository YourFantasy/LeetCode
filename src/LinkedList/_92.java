package LinkedList;

public class _92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode phead = new ListNode(0);
        int cnt = 1;
        phead.next = head;
        ListNode first;
        ListNode pre = phead, p = pre.next;
        while (cnt < m) {
            pre = p;
            p = p.next;
            cnt++;
        }
        first = pre;
        ListNode tail = p;
        ListNode q = null;
        while (cnt <= n) {
            ListNode tempnext = p.next;
            p.next = q;
            q = p;
            p = tempnext;
            cnt++;
        }
        first.next = q;
        tail.next = p;
        return phead.next;
    }
}
