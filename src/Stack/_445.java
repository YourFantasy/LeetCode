package Stack;

import LinkedList.ListNode;

import java.util.Stack;

class _445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode p = l1, q = l2;
        while (p != null) {
            stack1.push(p.val);
            p = p.next;
        }
        while (q != null) {
            stack2.push(q.val);
            q = q.next;
        }
        Stack<Integer> stack = new Stack<>();
        int m = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop() + stack2.pop() + m;
            stack.push(sum % 10);
            m = sum / 10;
        }
        while (!stack1.isEmpty()) {
            int sum = stack1.pop() + m;
            stack.push(sum % 10);
            m = sum / 10;
        }
        while (!stack2.isEmpty()) {
            int sum = stack2.pop() + m;
            stack.push(sum % 10);
            m = sum / 10;
        }
        if (m > 0) {
            stack.push(m);
        }
        ListNode pre = new ListNode(-1);
        p = pre;
        while (!stack.isEmpty()) {
            ListNode t = new ListNode(stack.pop());
            p.next = t;
            p = t;
        }
        return pre.next;
    }
}
