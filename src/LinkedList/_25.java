package LinkedList;

public class _25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = k;
        ListNode p = head, end = null;
        while (p != null && n != 0) {
            end = p;
            p = p.next;
            n--;
        }
        if (n != 0) {
            return head;
        }
        end.next = reverseKGroup(end.next, k);
        while (head != end) {
            p = head;
            head = head.next;
            p.next = end.next;
            end.next = p;
        }
        return end;
    }
}
