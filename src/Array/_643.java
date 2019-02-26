package Array;

import org.junit.Test;

public class _643 {
@Test
    public void Test(){
    System.out.println(Double.MIN_VALUE);
}

    public double findMaxAverage(int[] nums, int k) {
        double result=Double.MIN_VALUE;
        for(int i=0;i<=nums.length-k;i++){
            double sum=0;
            for(int j=i;j<i+k;j++){
                sum+=nums[j];
            }
            result=Math.max(result,sum/k);
        }
        return result;
    }
}
