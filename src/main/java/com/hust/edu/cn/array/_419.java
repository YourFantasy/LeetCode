package com.hust.edu.cn.array;

/**
 * @author YourFantasy
 * @date 2019-08-23 13:50
 */
class _419 {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length, cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag=board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.');
                if (flag) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
