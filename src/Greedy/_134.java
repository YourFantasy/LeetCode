package Greedy;

import org.junit.Test;

public class _134 {
    @Test
    public void test() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
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
}
