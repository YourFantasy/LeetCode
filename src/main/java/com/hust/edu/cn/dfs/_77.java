package com.hust.edu.cn.dfs;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
public class _77 {
    @Test
    public void test(){
        combine(9,7);

    }
    private List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        if(n<1||n<k) {
            return result;
        }
        List<Integer> temp=new ArrayList<>();
        dfs(n,k,1,result,temp,0);
        return result;
    }
    private void dfs(int n, int k, int start, List<List<Integer>> result, List<Integer> temp, int size){
        if(size==k){
            result.add(new ArrayList<>(temp));//结果添加到rusult中
            for(int i=0;i<k;i++) {
                System.out.print(temp.get(i)+",");
            }
            System.out.println();
            return ;
        }
        for(int i=start;i<=n;i++){
            temp.add(i);
            dfs(n,k,i+1,result,temp,size+1);
            temp.remove(size);//回溯(删掉最后一个添加的元素，向后回溯)
        }
    }
}
