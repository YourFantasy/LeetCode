package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class _817 {
    public int numComponents(ListNode head, int[] G) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < G.length; i++) {
            map.put(G[i], i);
        }
        int result = 0;
        ListNode p = head;
        while (p != null) {
            if (map.containsKey(p.val)) {
                result += 1;
                p = p.next;
                while (p != null && map.containsKey(p.val)) {
                    p = p.next;
                }
            } else {
                p = p.next;
            }
        }
        return result;

    }
}
