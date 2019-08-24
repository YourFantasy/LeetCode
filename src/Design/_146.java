package Design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _146 {
    class LRUCache {
        private Map<Integer, Integer> map;
        private int cap;
        private LinkedList<Integer> list;

        public LRUCache(int capacity) {
            cap = capacity;
            map = new HashMap<>();
            list = new LinkedList<>();
        }

        public int get(int key) {
            Integer temp = map.get(key);
            if (temp == null) {
                return -1;
            }
            list.remove( key);
            list.add(key);
            return temp;
        }

        public void put(int key, int value) {
            if (map.get(key) != null) {
                map.put(key, value);
                list.remove((Integer) key);
                list.add(key);
            } else {
                if (cap != map.size()) {
                    list.add(key);
                    map.put(key, value);
                } else {
                    Integer x = list.get(0);
                    map.remove(x);
                    map.put(key, value);
                    list.add(key);
                }
            }
        }
    }

}
