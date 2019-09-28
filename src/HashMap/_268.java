package HashMap;

import java.util.HashMap;

class _268 {

    public int missingNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int result=-1;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length+1;i++) {
            if (!map.containsKey(i)) {
                result=i;
                break;
            }
        }
        return result;
    }
}
