package LinkedList;

public class _19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prehead = new ListNode(0);
        ListNode p = head;
        prehead.next = head;
        ListNode pre = prehead;
        ListNode q = pre.next;
        int cnt = 0;
        while (p != null) {
            cnt++;
            if (cnt > n) {
                pre = q;
                q = q.next;
            }
            p = p.next;
        }
        pre.next = q.next;
        q = null;
        //remove(q);
        return prehead.next;

    }
}
