class Solution {
    /**
    * DFS
    * Time Complexity: O(m * n), m为面板高，n为面板的宽
    * Space Complexity: O(m * n), m为面板高，n为面板的宽,最坏情况需要扫描整个面板
    */
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if(board[x][y] == 'M') {// 踩雷
            board[x][y] = 'X';
            return board;
        }
        int m = board.length;
        int n = board[0].length;
        dfs(x, y, m, n, board);
        return board;
    }

    private void dfs(int x, int y, int m, int n, char[][] board) {
        if(x < 0 || x >= m || y < 0 || y >= n) return;
        if(board[x][y] != 'E') return;// 已开启
        int mine = 0;// 九宫格地雷总数
        for(int i = x - 1; i <= x + 1; i++) {
            for(int j = y - 1; j <= y + 1; j++) {
                if(i == x && j == y) continue;
                if(i >= 0 && i < m && j >= 0 && j < n && (board[i][j] == 'M' || board[i][j] == 'X')) {
                    mine++;
                }
            }
        }
        if(mine == 0) {// 空地，开启其他空地
            board[x][y] = 'B';
            for(int i = x - 1; i <= x + 1; i++) {
                for(int j = y - 1; j <= y + 1; j++) {
                    if(i == x && j == y) continue;
                    dfs(i, j, m, n, board);
                }
            }
        } else {// 数字
            board[x][y] = (char)('0' + mine);
        }
    }
}