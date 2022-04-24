## LeetCode-37-解数独

```java
public void solveSudoku1(char[][] board) {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] cell = new boolean[3][3][9];
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            char c = board[i][j];
            if (board[i][j] != '.') {
                int t = c - '1';
                row[i][t] = col[j][t] = cell[i / 3][j / 3][t] = true;
            }
        }
    }
    dfs(board, 0, 0, row, col, cell);
}

//递归返回值用boolean，任何一种子情况满足就返回true
private boolean dfs(char[][] board, int x, int y, boolean[][] row, boolean[][] col, boolean[][][] cell) {
    if (y == 9) {x++; y = 0;}
    if (x == 9) {return true;}
    if (board[x][y] != '.') return dfs(board, x, y + 1, row, col, cell);
    for (int i = 0; i < 9; i++) {
        if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]) {
            row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = true;
            board[x][y] = (char) (i + '1');
            if (dfs(board, x, y + 1, row, col, cell)) return true;
            row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = false;
            board[x][y] = (char) ('.');
        }
    }
    return false;
}
```