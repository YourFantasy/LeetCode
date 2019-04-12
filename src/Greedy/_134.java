package Greedy;

import org.junit.Test;

public class _134 {
    @Test
    public void test() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit1(gas, cost));
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int cnt = 0;
            int sum = gas[i];
            while (cnt <= len) {
                System.out.print(sum + ",");
                sum -= cost[(i + len + cnt) % len];
                if (sum < 0)
                    break;
                cnt++;
                sum += gas[(i + cnt + len) % len];
            }
            if (sum >= 0)
                return i;
        }
        return -1;
    }

    /**
     * 不管从那个位置出发，从出发点回到出发点，整个过程中加的油和消耗的油的总量都是一样的
     * 判断每个位置是否能到达下一个加油站，如果不能到达下一个加油站，则该位置被排除，index=(i+1)%len;
     * 判断最后总的加的油是否大于等于总的消耗的油，如果是，则返回index，否则返回-1
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int index = 0;
        int total = 0;
        int len = gas.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                index = (i + 1) % len;
            }
        }
        return (total >= 0) ? index : -1;
    }
}
