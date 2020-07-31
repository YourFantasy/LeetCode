package com.hust.edu.cn.tree;

public class _968 {

    int res = 0;

    /**
     * 父凭子贵，子凭父贵;祖没法凭孙贵，孙没法凭祖贵。
     * 0:该节点有两种选择1.父凭子贵。2.自力更生
     * 1.表明该节点自力更生，孩子节点跟着沾光
     * 0.5.表明该节点是沾孩子节点的光
     * 因为后序遍历，所以只能父亲沾儿子的光，父亲自力更生，儿子默认沾光。
     * <p>
     * 作者：YourFantasy
     * 链接：https://leetcode-cn.com/problems/binary-tree-cameras/solution/fu-ping-zi-gui-zi-ping-fu-gui-zu-mei-fa-ping-sun-g/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 如果needCamera(root)==3 说明左右孩子节点都是沾光而被填充的，但该位置没有被填充，所以需要再填充一次
        return needCamera(root) == 3 ? res + 1 : res;
    }

    /**
     * 遍历二叉树，0，1，2,3为返回标示。0：该位置已经填充了（但是是沾孩子节点的光而跟着填充）；1：该位置为叶子节点：2：该节点被填充（实打实的填充，而不是沾光） 3：该位置左右孩子节点都以为沾光被填充，但节点急需填充
     * <p>
     * <p>
     * 有三种可能性：
     * 1.该节点val=1表示是自力更生填充的，不沾孩子的光,左右孩子节点沾光而被填充为0.5
     * 2.该节点 val=0,分两种情况：1。如果该节点的孩子节点有一个为1，该节点可以沾光填充为0.5 2.该节点的父子或者孩子节点都为0.5或者0的话，没法沾光，只能靠自己
     * 3.该节点val=0.5，说明该节点沾孩子节点光而被填充为0.5
     *
     * @param root
     * @return
     */
    public int needCamera(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 叶子节点
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = needCamera(root.left);
        int right = needCamera(root.right);
        // 有两种情况
        // 1. ==1的情况：有一个孩子节点为叶子节点，所以该位置必须填充（因为叶子节点没有孩子节点，如果叶子节点cover到的话，必须填充该叶子节点或者该叶子节点的父节点，显然填充父节点更好，收益更大）
        // 2. ==3的情况：该节点没法靠孩子节点沾光被填充，只能自力更生
        if (left == 1 || right == 1 || left == 3 || right == 3) {
            res++;
            return 2;
        }

        // 左孩子或者右孩子节点有一个实打实的填充了话，该节点也沾光跟着被填充，返回0
        if (left == 2 || right == 2) {
            return 0;
        }
        // left=0&&right=0，表示该节点的左右孩子节点都被填充（但是左右孩子都是跟着沾光而被填充的，而不是实打实的填充，因为孩子节点都是沾光被填充的，不是实打实的填充，该节点没法继续沾孩子节点的光，只能自力更生），但该位置没有被填充
        return 3;
    }
}
