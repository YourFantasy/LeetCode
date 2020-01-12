package com.hust.edu.cn.hashMap;

import org.junit.Test;
/**
 * 使用三个辅助数组：map1、map2、map3
 * 三个数组起定位作用
 * map1[i][index]可以定位第第i行是否有重复元素
 * map2[index][j]可以定位到第j列是否有重复元素
 * map3[location][index]可以定位到在同一个3*3快内是否有重复元素，location = i / 3 * 3 + j / 3，所有在同一个3*3块内元素的location都相等
 */

/**
 * @author YourFantasy
 * @date 2019/9/29 2:37 下午
 * @description: 有效的数独
 */
public class _36 {
    @Test
    public void test() {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean res = isValidSudoku(board);
        System.out.println(res);
    }

    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int column = board[0].length;
        boolean[][] map1 = new boolean[row][column];
        boolean[][] map2 = new boolean[row][column];
        boolean[][] map3 = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '1';
                    int location = i / 3 * 3 + j / 3;
                    if (map1[i][index] || map2[index][j] || map3[location][index]) {
                        return false;
                    } else {
                        map1[i][index] = true;
                        map2[index][j] = true;
                        map3[location][index] = true;
                    }
                }
            }
        }
        return true;
    }
}
