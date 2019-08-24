package Array;

import org.junit.Test;

import java.util.HashMap;

public class _860 {
    @Test
    public void Test() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 3);
        map.put(1, 2);

        System.out.println(map);
        int[] bills = {5, 5, 5, 10, 5, 5, 10, 20, 20, 20};
        System.out.println(lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        int nums1 = 0;
        int nums2 = 0;
        for (int i = 0; i < bills.length; i++) {
            int money = bills[i];
            if (money == 5) {
                nums1++;

            }
            if (money == 10) {
                if (nums1 < 1) {
                    return false;
                } else {
                    nums2++;
                    nums1--;
                }
            }
            if (money == 20) {
                if (nums1 < 1) {
                    return false;
                } else {
                    if (nums1 * 5 + nums2 * 10 < 15) {
                        return false;
                    } else {
                        if (nums2 > 0) {
                            nums2--;
                            nums1--;
                        } else {
                            nums1 -= 3;
                        }
                    }
                }
            }
            System.out.println("5元张数: " + nums1);
            System.out.println("10元张数: " + nums2);
        }
        return true;
    }
}
