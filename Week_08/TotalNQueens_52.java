class Solution {
    public int totalNQueens(int n) {
        return backTracking(n, 0, 0, 0, 0);
    }

    private int backTracking(int n, int i, int colAndRow, int xySum, int xyDiff) {
        if(i == n) return 1;
        int ways = 0;
        int bits = (~(colAndRow | xySum | xyDiff)) & ((1 << n) - 1);
        while(bits != 0) {
            int p = bits & (-bits);
            bits &= bits - 1;
            ways += backTracking(n, i + 1, colAndRow | p, (xySum | p) >> 1, (xyDiff | p) << 1);
        }
        return ways;
    }
}