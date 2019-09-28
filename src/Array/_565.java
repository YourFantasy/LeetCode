package Array;

/**
 * @author YourFantasy
 * @date 2019-08-26 15:49
 * @description: 数组嵌套
 */
class _565 {
    public int arrayNesting(int[] nums) {
        int res=1;
        boolean[] visited=new boolean[nums.length];
        for (int num : nums) {
            if (res > nums.length / 2) {
                return res;
            }
            if (visited[num]) {
                continue;
            }
            visited[num] = true;
            int index = nums[num];
            int max = 1;
            while (index != num) {
                visited[index] = true;
                max++;
                index = nums[index];
            }
            res = Math.max(max, res);
        }
        return res;
    }
}
