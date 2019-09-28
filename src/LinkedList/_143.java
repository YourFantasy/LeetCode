package LinkedList;

/**
 * 思路：通过观察可知，第len/2+1个节点经过重排之后成为尾节点，所以有如下思路：
 * 1.通过快慢指针的方式找到第len/2+1个节点，设这个节点为mid，然后mid节点之后的链表进行翻转
 * 2.将mid节点之后的链表依次插入到mid节点之前的链表中去
 * 3.因为mid节点变成了尾节点，所以将mid节点的next节点置空
 *举例  1 2 3 4
 *      mid：3  翻转之后为 1 2 3 4 然后将3之后的所有节点依次插入到前面中去，变成 1 4 2 3
 * 举例  1 2 3 4 5
 *      mid: 3 翻转之后为 1 2 3 5 4 然后将3之后的链表节点依次插入到前面中去，变成 1 5 2 4 3
 */
class _143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = head, p = head;
        while (p != null && p.next != null) {
            mid = mid.next;
            p = p.next.next;
        }
        ListNode qpre = null;
        ListNode q = mid.next;
        while (q != null) {
            ListNode tempnext = q.next;
            q.next = qpre;
            qpre = q;
            q = tempnext;
        }
        mid.next = qpre;
        p = head;
        while (qpre != null) {
            ListNode temp1 = p.next;
            ListNode temp2 = qpre.next;
            p.next = qpre;
            qpre.next = temp1;
            p = temp1;
            qpre = temp2;
        }
        mid.next = null;
    }
}
