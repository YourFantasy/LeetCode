package com.hust.edu.cn.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _118 {
    @Test
    public void test(){
        System.out.println(generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        if(numRows==0) {
            return res;
        }
        List<Integer> temp=new ArrayList<>();
        temp.add(1);
        res.add(temp);
        int left,right;
        for(int i=1;i<numRows;i++){
            temp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0){
                   left=0;
                }
                else {
                    left=res.get(i-1).get(j-1);
                }

                if(j==i) {
                    right=0;
                } else {
                    right=res.get(i-1).get(j);
                }
                temp.add(left+right);
            }
            res.add(temp);
        }
        return res;
    }
}
