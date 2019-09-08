package Array;

/**
 * @author YourFantasy
 * @date 2019-08-26 15:49
 * @description: 数组嵌套
 */
public class _565 {
    public int arrayNesting(int[] nums) {
        int res=1;
        boolean[] visited=new boolean[nums.length];
        for (int i=0;i<nums.length;i++){
            if (res>nums.length/2) {
                return res;
            }
            if (visited[nums[i]]){
                continue;
            }
            visited[nums[i]]=true;
            int index=nums[nums[i]];
            int max=1;
            while (index!=nums[i]){
                visited[index]=true;
                max++;
                index=nums[index];
            }
            res=Math.max(max,res);
        }
        return res;
    }
}
