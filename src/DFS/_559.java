package DFS;

import java.util.List;

public class _559 {
    public int maxDepth(Node root) {
        if(root==null)
            return 0;
        int max=1;
        for(Node children:root.children){
            max=Math.max(max,maxDepth(children)+1);
        }
        return max;
    }

}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
