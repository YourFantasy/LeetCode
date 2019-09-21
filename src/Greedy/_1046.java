package Greedy;

/**
 * @author YourFantasy
 * @date 2019/9/21 9:22 上午
 * @description: 最后一块石头的重量
 * <p>
 * 思路：贪心算法
 * 每次找到数组中最大和最小的元素，二者相减
 * 将最大元素的值重新赋值为上述元素的差值
 * 将第二大元素的值重新赋值为0
 */
public class _1046 {
    public int lastStoneWeight(int[] stones) {

        if (stones.length == 1) {
            return stones[0];
        }
        int[] index = new int[2];
        findFirstAndSecond(stones, index);
        int i = index[0], j = index[1];

        while (stones[i] != 0 && stones[j] != 0) {
            int sub = stones[i] - stones[j];
            stones[i] = sub;
            stones[j] = 0;
            findFirstAndSecond(stones, index);
            i = index[0];
            j = index[1];
        }
        return stones[i];
    }

    public void findFirstAndSecond(int[] stones, int[] index) {
        int index1 = 0, index2 = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] > stones[index1]) {
                index1 = i;
            }
        }
        int max2 = -1;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] >= max2 && i != index1) {
                max2 = stones[i];
                index2 = i;
            }
        }
        index[0] = index1;
        index[1] = index2;
    }
}
