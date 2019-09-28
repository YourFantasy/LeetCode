package Tree;

class _654 {
    TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode res = new TreeNode(1);
        Pre_order(0, nums.length - 1, res, nums);
        return res;

    }

    private TreeNode Pre_order(int i, int j, TreeNode root, int[] nums) {
        if (i <= j) {
            int index = find_max(i, j, nums);
            root.val = nums[index];
            TreeNode left = new TreeNode(0);
            TreeNode right = new TreeNode(0);
            root.left = Pre_order(i, index - 1, left, nums);
            root.right = Pre_order(index + 1, j, right, nums);
            return root;

        }
        return null;
    }

    private int find_max(int i, int j, int[] nums) {
        int max = nums[i];
        int index = i;
        for (int k = i + 1; k <= j; k++) {
            if (max < nums[k]) {
                max = nums[k];
                index = k;
            }
        }
        return index;
    }
}
