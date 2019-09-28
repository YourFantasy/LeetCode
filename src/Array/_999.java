package Array;

class _999 {
    public int numRookCaptures(char[][] board) {
        int n = board.length;
        int x = -1, y = -1;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        int cnt = 0;
        int i = x - 1, j = x + 1;
        int m = y - 1, k = y + 1;
        while (i >= 0 && board[i][y] != 'B') {
            if (board[i][y] == 'p') {
                cnt++;
                break;
            }
            i--;
        }
        while (j < n && board[j][y] != 'B') {
            if (board[j][y] == 'p') {
                cnt++;
                break;
            }
            j++;
        }
        while (m >= 0 && board[x][m] != 'B') {
            if (board[x][m] == 'p') {
                cnt++;
                break;
            }
            m--;
        }
        while (k < n && board[x][k] != 'B') {
            if (board[x][k] == 'p') {
                cnt++;
                break;
            }
            k++;
        }
        return cnt;
    }
}
