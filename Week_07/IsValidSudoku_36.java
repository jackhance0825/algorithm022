class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] cols = new int[9];
        int[] rows = new int[9];
        int[] block = new int[9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                int c = 1 << (int)(board[i][j] - '1');// 0-8
                if((cols[j] & c) > 0 || (rows[i] & c) > 0 || (block[(i / 3) * 3 + j / 3] & c) > 0) return false;
                cols[j] |= c;
                rows[i] |= c;
                block[(i / 3) * 3 + j / 3] |= c;
            }
        }
        return true;
    }
}