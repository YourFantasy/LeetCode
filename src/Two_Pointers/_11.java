package Two_Pointers;

class _11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            int h = (height[j] > height[i]) ? height[i++] : height[j--];
            res = Math.max(res, h * (j - i + 1));
        }
        return res;
    }
}
