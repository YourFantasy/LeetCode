package com.hust.edu.cn.design;

import java.util.Random;

public class _1206 {
    // 链表的最大层数
    private final int maxLevel = 1 << 4;
    /**
     * 最顶层链表的虚拟head节点
     */
    private Node head;
    /**
     * 随机数，抛硬币
     */
    private static final Random random = new Random();
    /**
     * 添加node的时候用到
     */
    Node[] stack = new Node[maxLevel];


    public _1206() {
        head = new Node(-1, null, null);
    }

    public boolean search(int target) {
        // 遍历每一层链表，从最顶层开始
        for (Node p = head; p != null; p = p.down) {
            // 在当前层进行查找
            while (p.next != null && p.next.val < target) {
                p = p.next;
            }
            // 如果当前层有满足条件的node，返回true
            if (p.next != null && p.next.val == target) {
                return true;
            }
        }
        // 所有层都没有符合条件的node
        return false;
    }

    public void add(int num) {
        int cur = -1;
        // 每一层查找大于等于num的节点，目的是保证每一层的链表都是有序的
        for (Node p = head; p != null; p = p.down) {
            // 找到每层
            while (p.next != null && p.next.val < num) {
                p = p.next;
            }
            stack[++cur] = p;
        }

        boolean flag = true;
        Node downNode = null;
        // 从最后一层开始插入，逐步向上层插入，抛硬币做法，如果flag为false，终止过程
        while (flag && cur >= 0) {
            Node node = stack[cur--];
            // 最后一层必须得插入，因为最后一层存储真实数据
            node.next = new Node(num, downNode, node.next);
            downNode = node.next;
            // 插与不插的概率各位1/2
            flag = (random.nextInt() & 1) == 0;
        }

        if (flag) {
            head = new Node(0, head, new Node(num, downNode, null));
        }

    }

    public boolean erase(int num) {
        boolean exist = false;
        // 如果存在，删除当前层的num
        for (Node p = head; p != null; p = p.down) {
            while (p.next != null && p.next.val < num) {
                p = p.next;
            }
            // 如果当前层存在num，删除之，当前层存在，说明最后一层也肯定存在
            if (p.next != null && p.next.val == num) {
                exist = true;
                // 删除该节点
                p.next = p.next.next;
            }
        }

        return exist;

    }

    private class Node {
        private final int val;
        private final Node down;
        private Node next;

        public Node(int val, Node down, Node next) {
            this.val = val;
            this.down = down;
            this.next = next;
        }
    }
}
