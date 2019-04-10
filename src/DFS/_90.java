package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        res.add(new ArrayList<>());
        dfs(nums,res,0,temp);
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, int begin, List<Integer> temp){
        for(int i=begin;i<nums.length;i++){
            temp.add(nums[i]);
            dfs(nums,res,i+1,temp);
            temp.remove(temp.size()-1);
        }
        if(temp.size()>0&&!res.contains(temp)){
            res.add(new ArrayList<>(temp));
            return ;
        }
    }
}
