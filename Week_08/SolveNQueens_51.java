class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        backTracking(res, n, new int[n], 0, 0, 0, 0);
        return res;
    }

    private void backTracking(List<List<String>> res, int n, int[] rows, int i, int colAndRow, int xySum, int xyDiff) {
        if(i == n) {
            List<String> list = new ArrayList<>(n);
            for(int j = 0; j < n; j++) {
                char[] cs = new char[n];
                for(int k = 0; k < n; k++) {
                    cs[k] = (rows[j] >> k) == 1 ? 'Q' : '.'; 
                }
                list.add(new String(cs));
            }
            res.add(list);
            return;
        }
        int bits = (~(colAndRow | xySum | xyDiff)) & ((1 << n) - 1);
        while(bits != 0) {
            int p = rows[i] = bits & (-bits);
            bits &= bits - 1;
            backTracking(res, n, rows, i + 1, colAndRow | p, (xySum | p) << 1, (xyDiff | p) >> 1);
        }
    }
}