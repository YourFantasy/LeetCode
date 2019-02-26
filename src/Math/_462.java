package Math;

import java.util.Arrays;

public class _462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        int key=nums[nums.length/2];
        for(int i=0;i<nums.length/2;i++){
            result+=key-nums[i];
        }
        for(int i=nums.length/2+1;i<nums.length;i++){
            result+=nums[i]-key;
        }
        return result;
    }
}
