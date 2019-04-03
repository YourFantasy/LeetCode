package Two_Pointers;

public class _209 {
    //使用双指针实现滑动窗口，i始终指向满足sum>=s时左边元素，j是工作指针。i作为指向左边元素的指针，所以不能指向最后一个元素，不然sum为0。
    public int minSubArrayLen(int s, int[] nums) {
        int res = nums.length + 1;
        int i = 0, j = 0;
        int sum = 0;
        while (i < nums.length - 1) {
            if (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            } else {
                sum -= nums[i];
                i++;
            }
            if (sum >= s) res = Math.min(res, j - i);

        }
        if (res < nums.length + 1)
            return res;
        return 0;
    }
}
