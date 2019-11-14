package LinkedList;


import java.util.HashMap;
import java.util.Map;

public class _1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode preHead = pre;
        pre.next = head;
        ListNode p = pre.next;
        if (sum(preHead.next) == 0) {
            return null;
        }
        while (p != null && sum(pre.next) != 0) {
            ListNode m = p;
            int sum = 0;
            boolean flag = false;
            while (m != null) {
                sum += m.val;
                if (sum == 0) {
                    flag = true;
                    break;
                }
                m = m.next;
            }
            if (flag) {
                pre.next = m.next;
                p = pre.next;

            } else {
                pre = p;
                p = pre.next;
            }
        }
        if (sum(pre.next) == 0) {
            pre.next = null;
        }
        return preHead.next;
    }

    public int sum(ListNode head) {
        int res = 0;
        while (head != null) {
            res += head.val;
            head = head.next;
        }
        return res;
    }

    /**
     * 精妙解法，充分利用 total+0=total，如果中间某一段为0的话，假设从pi----pj，这段和为0，则pm---pj(m在i前)这段和等于
     *
     * @param head
     * @return
     */
    public ListNode removeZeroSumSublists1(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        int sum = 0;
        for (ListNode p = preHead; p != null; p = p.next) {
            sum += p.val;
            map.put(sum, p);
        }
        sum = 0;
        for (ListNode p = preHead; p != null; p = p.next) {
            sum += p.val;
            p.next = map.get(sum).next;

        }
        return preHead.next;
    }
}
