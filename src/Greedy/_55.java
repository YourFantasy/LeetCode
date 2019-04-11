package Greedy;

import org.junit.Test;

public class _55 {
    @Test
    public void test() {
        int len=10;
        int[] nums=new int[len];
        for (int i=0;i<len;i++){
            nums[i]=(int)(Math.random()*5);
            System.out.print(nums[i]+",");
        }
        System.out.println();
        System.out.println(canJump(nums));
        //System.out.println(canJump(new int[]{2,0,0}));
    }

    public boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;
        int max = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 0&&max<=i)
                    return false;
            max = Math.max(max, nums[i] + i);

        }
        return max>=nums.length-1;
    }
}
