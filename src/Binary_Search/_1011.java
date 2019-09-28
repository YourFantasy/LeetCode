package Binary_Search;

class _1011 {
    /**
     * 二分查找，找到所需的最小容量
     * 分析：
     * 1.先求重量之和和找到最大的一个重量
     * 2.mid=(max+sum)/2;
     * 3.以mid为标杆，计算有几组连续包裹重量和大于mid，记为cnt；
     * 如果cnt<D,说明mid太大了
     * 同理，如果cnt>=D,说明mid太小了
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        int len = weights.length;
        int sum = 0;
        int max = 0;
        for (int value : weights) {
            max = Math.max(value, max);
            sum += value;
        }
        while (max <= sum) {
            int total = 0;
            int mid = max + (sum - max) / 2;
            int cnt = 0;
            for (int weight : weights) {
                total += weight;
                if (total > mid) {
                    cnt++;
                    total = weight;
                }
            }
            if (cnt < D) {
                sum = mid - 1;
            } else {
                max = mid + 1;
            }
        }
        return max;
    }
}
