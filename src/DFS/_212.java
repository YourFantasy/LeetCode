package DFS;

import java.util.ArrayList;
import java.util.List;

class _212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (String word : words) {
                    if (dfs(board, i, j, m, n, word, 0)) {
                        res.add(word);
                    }
                }
            }
        }
        return res;
    }

    private boolean dfs(char[][] board, int i, int j, int m, int n, String word, int cnt) {
        if (i >= m || i < 0 || j >= n || j < 0 || cnt >= word.length()) {
            return false;
        }
        if (word.charAt(cnt) != board[i][j]) {
            return false;
        }
        if (cnt == word.length()) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        boolean res = dfs(board, i + 1, j, m, n, word, cnt + 1) || dfs(board, i - 1, j, m, n, word, cnt + 1) || dfs(board, i, j + 1, m, n, word, cnt + 1) || dfs(board, i, j - 1, m, n, word, cnt + 1);
        board[i][j] = temp;
        return res;

    }
}
