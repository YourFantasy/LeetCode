package Binary_Search;

//分别寻找左边的索引和右边的索引。两次二分查找
class _34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1 || (nums.length == 1 && nums[0] != target)) {
            return new int[]{-1, -1};
        }
        int begin = find_left(nums, target);
        int end = find_right(nums, target);
        return new int[]{begin, end};
    }

    private int find_left(int[] nums, int target) {
        int i = 0, j = nums.length - 1, begin = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int data = nums[mid];
            if (data == target) {
                begin = mid;
                j = mid - 1;
            } else if (data < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return begin;
    }

    private int find_right(int[] nums, int target) {
        int i = 0, j = nums.length - 1, end = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int data = nums[mid];
            if (data == target) {
                end = mid;
                i = mid + 1;
            } else if (data < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return end;
    }

}
