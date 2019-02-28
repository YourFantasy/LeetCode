package Two_Pointers;

public class _713 {
    /**
     * j为工作指针
     * i始终指向当b<k时的起始位置，并且此时i在j处或者j前面
     * 设置b为数组的连续的乘积，如果b>=k,此时不满足，所以b=b/nums[i];
     * 设数组为a0,a1,a2,a3....ak,...am...an;如果ak*ak+1*...am<k,此时的个数为cnt，若ak*ak+1*...am*am+1<k, 此时的个数为cnt+m+1-k+1
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0;
        int i = 0, j = 0;
        int b = 1;
        while (j < nums.length) {
            b *= nums[j];
            while (i <= j && b >= k) {
                b = b / nums[i];
                i++;
            }
            cnt += j - i + 1;//当（b<k）时的个数，如果b==1.此时表明单个元素的指都大于k，所以此时的个数为0；
            j++;
        }
        return cnt;
    }
}
