package Sort;

import org.junit.Test;

/**
 * 思路：定义三个指针，其中k是工作指针，i是前半部分指针，j是后半部分指针。k开始工作，一旦碰到0就和i指向的元素交换，此时因为i指向的元素为0了，所以i+=1，因为i和i之前的元素只可能是0或者1，所以此时无需判断经过交换之后此时k所指向的元素，所以k+=1（若是0，免去交换，若是1，也不用交换）如果nums[k]=1,k继续向前走，若此时nums[k]=2，交换nums[k]和nums[j],此时nums[j]=2，所以j-=1，但是此时无法判断经过交换之后nums[k]是否为2，所以k保持不动
 * 重复上述过程，直到k==j，此时j和k重合，再判断这最后一个可能需要移动的元素的值。若为0，交换，交换后的值是1，k++;若为1，k++，若为2。交换,交换后的值是1，j--;
 * 核心思想:遍历数组，判断是0，1还是2。0：扔到前半部分，前半部分指针+1，工作指针加1。1：不管，继续向前走。2：扔到后半部分，后半部分指针-1，工作指针原地不变(无法判断交换之后元素的值,只有为1的情况才不管，此时，k++)
 */
public class _75 {
    @Test
    public void test() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private void sortColors(int[] nums) {
        int i = 0, k = 0, j = nums.length - 1;
        while (k <= j) {
            while (k <= j && nums[k] == 0) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                i++;
                k++;
            }
            while (k <= j && nums[k] == 1) {
                k++;
            }
            while (k <= j && nums[k] == 2) {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                if (nums[k] == 1) {
                    k++;
                }
                j--;
            }
        }
    }

    public void sortColors1(int[] nums) {
        int i = 0, k = 0, j = nums.length - 1;
        while (k <= j) {
            if (nums[k] == 1) {
                k++;
            } else if (nums[k] == 0) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                i++;
                k++;
            } else {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
    }
}
