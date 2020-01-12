package com.hust.edu.cn.dfs;

class _79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int cnt) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || cnt >= word.length() || board[i][j] != word.charAt(cnt)) {
            return false;
        }
        if (cnt == word.length() - 1) {
            return true;
        }
        char ch = board[i][j];
        board[i][j] = '.';
        boolean res = dfs(board, word, i + 1, j, cnt + 1) || dfs(board, word, i - 1, j, cnt + 1) || dfs(board, word, i, j + 1, cnt + 1) || dfs(board, word, i, j - 1, cnt + 1);
        board[i][j] = ch;
        return res;

    }
}
