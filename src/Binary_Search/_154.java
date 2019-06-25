package Binary_Search;

/**
 * nums[mid]与nums[j]比较而不与nums[i]比较的原因在于，如果该数组本身没有经过旋转而且有重复元素并且是有序的话，就无法得知具体情况，但是与nums[j]比较的话就可以知道数组一定是经过了旋转
 * 此类二分查找题目总结：1。将数组分为两部分，前半部分和后半部分都是有序数组，并且前半位置的最小值大于等于后半位置的最大值，2。确定旋转点的位置：如果nums[mid]>nums[j]，说明旋转点在前半位置，nums[mid]>nums[j],则在后半位置；相等的话则无法确认位置
 */
public class _154 {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[j])
                i = mid + 1;
            else if (nums[mid] < nums[j])
                j = mid;
            else
                j -= 1;
        }
        return nums[i];
    }
}
