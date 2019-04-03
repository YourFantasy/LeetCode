package LinkedList;

//画图分析，一目了然
public class _142 {
    public ListNode detectCycle(ListNode head) {
        ListNode L = head, R = head;
        boolean flag = false;
        while (R != null && R.next != null) {
            L = L.next;
            R = R.next.next;
            if (L == R) {
                flag = true;
                break;
            }
        }
        if (flag) {
            ListNode p = head;
            while (p != L) {
                p = p.next;
                L = L.next;

            }
            return p;
        }
        return null;
    }
}
