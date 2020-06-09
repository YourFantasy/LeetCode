/**
 * @(#)Test.java, 6月 08, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.hust.edu.cn.array;

/**
 * @author chenzhibj
 */
public class Test {

    @org.junit.Test
    public void test(){
        String str="2sdfds4f";
        System.out.println(str.lastIndexOf("/"));
        String s=str.substring(str.lastIndexOf("/")+1);
        System.out.println(s);
    }

}