package com.hust.edu.cn.dfs;

import java.util.List;

class _559 {
    private int maxDepth(Node root) {
        if(root==null) {
            return 0;
        }
        int max=1;
        for(Node children:root.children){
            max=Math.max(max,maxDepth(children)+1);
        }
        return max;
    }

}
class Node {
    private int val;
    List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
