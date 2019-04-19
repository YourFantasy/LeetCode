package LinkedList;

public class _160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        int La = 0, Lb = 0;
        while (p != null) {
            La++;
            p = p.next;
        }
        while (q != null) {
            Lb++;
            q = q.next;
        }
        p = headA;
        q = headB;
        int k = Math.abs(La - Lb);
        if (La >= Lb) {
            while (k > 0) {
                p = p.next;
                k--;
            }
        } else {
            while (k > 0) {
                q = q.next;
                k--;
            }
        }
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
