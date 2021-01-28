class Solution {
    /**
    * 回溯
    * TimeCOmplexity: O(n^n)
    */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        int skim = 0;
        int restrain = 0;
        int colAndRow = 0;
        int[] cols = new int[n];
        backTracking(res, skim, restrain, colAndRow, cols, 0, n);
        return res;
    }

    private void backTracking(List<List<String>> res, int skim, int restrain, int colAndRow, int[] cols, int i, int n) {
        if(i == n) {
            List<String> list = new ArrayList<>(n);
            char[] cs = new char[n];
            for(int col : cols) {
                for(int j = 0; j < n; j++) {
                    cs[j] = j == col ? 'Q' : '.';
                }
                list.add(new String(cs));
            }
            res.add(list);
            return;
        }
        for(int j = 0; j < n; j++) {
            int colAndRowMask = 1 << j;
            int skimMask = 1 << (i + j);
            int restrainMask = 1 << ((i - j) + n);
            if((colAndRow & colAndRowMask) > 0 || (skim & skimMask) > 0 || (restrain & restrainMask) > 0) continue;
            cols[i] = j;
            colAndRow |= colAndRowMask;
            skim |= skimMask;
            restrain |= restrainMask;
            backTracking(res, skim, restrain, colAndRow, cols, i + 1, n);
            colAndRow &= ~colAndRowMask;
            skim &= ~skimMask;
            restrain &= ~restrainMask;
        }
    }
}