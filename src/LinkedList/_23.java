package LinkedList;

class _23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        for (int i = 0; i < len - 1; i++) {
            lists[i + 1] = merge(lists[i], lists[i + 1]);
        }
        return lists[len - 1];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode L = new ListNode(0);
        ListNode p = L;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;


        }
        while (p1 != null) {
            p.next = p1;
            p1 = p1.next;
            p = p.next;
        }
        while (p2 != null) {
            p.next = p2;
            p2 = p2.next;
            p = p.next;
        }
        return L.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergetList(lists, 0, lists.length - 1);
    }

    public ListNode mergetList(ListNode[] lists, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            ListNode p1 = mergetList(lists, left, mid);
            ListNode p2 = mergetList(lists, mid + 1, right);
            return merge1(p1, p2);
        }
        return lists[left];
    }

    public ListNode merge1(ListNode p1, ListNode p2) {
        ListNode pre = new ListNode(0);
        pre.next = p1;
        ListNode p = pre;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p2;
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            p.next = p1;
            p = p1;
            p1 = p1.next;
        }
        while (p2 != null) {
            p.next = p2;
            p = p2;
            p2 = p2.next;
        }
        return pre.next;
    }
}