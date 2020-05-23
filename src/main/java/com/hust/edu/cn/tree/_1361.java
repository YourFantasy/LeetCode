package com.hust.edu.cn.tree;

public class _1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        /**
         * 只有一个根节点，左右孩子结点都为空
         */
        if (n == 1) {
            return leftChild[0] == -1 && rightChild[0] == -1;
        }
        int[] cnt = new int[n];
        /**
         * 一颗二叉树的两个条件：
         *  1.每个子节点有且只有一个父节点，即每个结点的入度不能大于1
         *  2.有且仅有根节点没有父节点，即只有一个结点（根结点）的入度为0
         */
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                cnt[leftChild[i]]++;
                // 如果入度大于1 直接返回false 违反条件1
                if (cnt[leftChild[i]] > 1) {
                    return false;
                }
            }
            if (rightChild[i] != -1) {
                cnt[rightChild[i]]++;
                // 如果入度大于1 直接返回false 违反条件1
                if (cnt[rightChild[i]] > 1) {
                    return false;
                }
            }
        }
        int count = 0;
        int index = -1;
        // 统计入度为0的结点个数，index为根节点编号
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0) {
                count++;
                index = i;
            }
        }
        // 违反条件2
        if (count != 1) {
            return false;
        }
        // 因为n>1,所以此时根节点的左右孩子不可能同时为空，如果同时同时为空，说明不是一颗二叉树
        return leftChild[index] != -1 || rightChild[index] != -1;
    }
}
