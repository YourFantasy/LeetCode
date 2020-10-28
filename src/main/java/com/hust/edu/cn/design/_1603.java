package com.hust.edu.cn.design;

import java.util.HashMap;
import java.util.Map;

public class _1603 {

    private static Map<Integer, Integer> mp = new HashMap<>();

    public _1603(int big, int medium, int small) {
        mp.put(1, big);
        mp.put(2, medium);
        mp.put(3, small);
    }

    public boolean addCar(int carType) {
        if (mp.get(carType) <= 0) {
            return false;
        }
        mp.put(carType, mp.get(carType) - 1);
        return true;
    }

}


