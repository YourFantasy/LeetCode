package com.hust.edu.cn.design;

import java.util.HashMap;
import java.util.Map;

class _146 {
    class LRUCache {
        class Node {
            private int key;
            private int val;
            private Node next;
            private Node pre;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private int size;
        private Map<Integer, Node> map;
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            this.size = capacity;
            tail = new Node(-1, -1);
            head = new Node(-1, -1);
            tail.pre = head;
            head.next = tail;
            map = new HashMap<>(capacity, 1);
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            unlink(node);
            addHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) {
                unlink(map.get(key));
                map.remove(key);
            }
            if (map.size() >= size) {
                Node last = removeLast();
                map.remove(last.key);
            }
            addHead(node);
            map.put(key, node);
        }

        private void addHead(Node node) {
            node.next = head.next;
            head.next.pre = node;
            node.pre = head;
            head.next = node;
        }

        private void unlink(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private Node removeLast() {
            Node last = tail.pre;
            last.pre.next = last.next;
            last.next.pre = last.pre;
            return last;
        }
    }


}
