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

    public int[] searchRange1(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums == null || nums.length == 0) {
            return res;
        }
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int m = i + (j - i) / 2;
            if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m;
            }
        }

        if (nums[i] != target) {
            return res;
        }
        res[0] = i;
        j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] > target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        res[1] = j;
        return res;
    }
}
