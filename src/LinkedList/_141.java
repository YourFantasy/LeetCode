package LinkedList;

public class _141 {
    public boolean hasCycle(ListNode head) {
        ListNode L = head, R = head;
        while (R != null && R.next != null) {
            L = L.next;
            R = R.next.next;
            if (R != null && (R == L || L == R.next))
                return true;
        }
        return false;

    }
}
