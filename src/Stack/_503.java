package Stack;

public class _503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = 1; j < len; j++) {
                int temp = (i + j) % len;
                if (nums[temp] > nums[i]) {
                    result[i] = nums[temp];
                    flag = true;
                    break;
                }

            }
            if (flag == false)
                result[i] = -1;
        }
        return result;
    }
}
