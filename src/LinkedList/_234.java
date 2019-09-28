package LinkedList;

class _234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode L = head, R = head;
        while (R != null && R.next != null) {
            R = R.next.next;
            L = L.next;
        }
        ListNode q;
        if (R == null) {
            q = L;
        } else {
            q = L.next;
        }
        ListNode pre = null;
        while (q != null) {
            ListNode temp = q.next;
            q.next = pre;
            pre = q;
            q = temp;
        }
        while (pre != null) {
            if (head.val == pre.val) {
                pre = pre.next;
                head = head.next;
            } else {
                break;
            }
        }
        return pre == null;
    }
}
