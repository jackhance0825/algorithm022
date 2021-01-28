class Solution {
    public void solveSudoku(char[][] board) {
        int[] cols = new int[9];
        int[] rows = new int[9];
        int[] blocks = new int[9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                int m = 1 << (board[i][j] - '1');
                cols[j] |= m;
                rows[i] |= m;
                blocks[(i / 3) * 3 + j / 3] |= m; 
            }
        }
        backTracking(board, 0, cols, rows, blocks);
    }

    private boolean backTracking(char[][] board, int i, int[] cols, int[] rows, int[] blocks) {
        if(i == 81) return true;
        int row = i / 9;
        int col = i % 9;
        if(board[row][col] != '.') return backTracking(board, i + 1, cols, rows, blocks);
        for(char c = '1'; c <= '9'; c++) {
            int m = 1 << (c - '1');
            if((cols[col] & m) > 0 || (rows[row] & m) > 0 || (blocks[(row / 3) * 3 + col / 3] & m) > 0) continue;
            board[row][col] = c;
            cols[col] |= m;
            rows[row] |= m;
            blocks[(row / 3) * 3 + col / 3] |= m;
            if(backTracking(board, i + 1, cols, rows, blocks)) return true;
            cols[col] &= ~m;
            rows[row] &= ~m;
            blocks[(row / 3) * 3 + col / 3] &= ~m;
            board[row][col] = '.';
        }
        return false;
    }
}