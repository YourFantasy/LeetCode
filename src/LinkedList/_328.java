package LinkedList;

public class _328 {
    //分别把奇数位的元素和偶数位的元素连接起来，然后在把奇数位的元素和偶数位的元素连接起来
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode q = head.next;
        ListNode t = p.next;
        while (p.next != null && t.next != null) {
            p.next = t.next;//连接奇数位元素
            p = p.next;
            t.next = p.next;//连接偶数位元素
            t = t.next;
        }
        p.next = q;//将奇数位和偶数位连接起来
        return head;
    }
}
