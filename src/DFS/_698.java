package DFS;

import org.junit.Test;

public class _698 {
    @Test
    public void test() {
        int len = 10;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = (int) (Math.random() * 10 - 5);
            System.out.print(nums[i] + ",");
        }
        System.out.print(canPartitionKSubsets(nums, 4));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (k < 1 || sum % k != 0)
            return false;
        int a = sum / k;
        boolean[] flag = new boolean[nums.length];
        return dfs(nums, k, a, 0, flag, 0, 0);
    }

    /*
     * 核心思想：如果A部分可以分割成功，剩余B部分也分割成功，并且A部份分的块数与B部份分的块数之和为k，而且在这个过程中没有元素被重复使用，则认为整个数组可以被分割成功。
     * 其中各参数
     * a：数组元素平均值
     * flag：标记数组中元素是否被访问的数组
     * begin:当前递归中开始的元素索引
     * sum：当前递归中元素之和
     * cnt：当前递归中参与相加的元素个数(当a=0的时候，cnt为0，此时sum永远为0，因为此时不需要元素相加，所以要统计相加的元素个数)
     *
     * */
    boolean dfs(int[] nums, int k, int a, int begin, boolean[] flag, int sum, int cnt) {
        if (k == 1)//剩下部分：因为其余部分都分割成功，而且sum%k==0，所以剩下部分一定满足条件，此时所有部份都成功分割，分割成功！
            return true;
        if (cnt > 0 && sum == a)//A部分分割成功，判断剩余B部份是否能够成功分割
            return dfs(nums, k - 1, a, 0, flag, 0, 0);
        for (int i = begin; i < nums.length; i++) {
            if (!flag[i]) {//保证数组元素不被重复使用
                flag[i] = true;//数组元素被使用
                if (dfs(nums, k, a, i + 1, flag, sum + nums[i], cnt + 1))
                    return true;
                flag[i] = false;//分割失败，回退，重新进行组合分割
            }
        }
        return false;//遍历完数组仍不能够完全分割成功，此时认为该数组不能够按要求分割
    }
}
