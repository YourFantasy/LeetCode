package com.hust.edu.cn.array;

import org.junit.Test;

public class _860 {
    @Test
    public void Test() {
        int[] bills = {5, 5, 5, 10, 5, 5, 10, 20, 20, 20};
        System.out.println(lemonadeChange(bills));
    }

    private boolean lemonadeChange(int[] bills) {
        int nums1 = 0;
        int nums2 = 0;
        for (int money : bills) {
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
