class Solution {
    public List<List<String>> solveNQueens(int n) {
        // 记录撇是否被占用，取值范围[0, 2n-2]
        boolean[] skim = new boolean[2 * n];
        // 记录捺是否被占用，取值范围[-(n-1), n-1]，数值向右递增n后，[1, 2n-1]
        boolean[] restrain = new boolean[2 * n];
        // 记录行列占用情况
        boolean[] cols = new boolean[n];
        char[][] pos = new char[n][n];
        List<List<String>> ans = new LinkedList<>();
        backtracking(n, 0, pos, cols, skim, restrain, ans);
        return ans;
    }

    private void backtracking(int n, int row, char[][] pos, boolean[] cols, boolean[] skim, boolean[] restrain, List<List<String>> ans) {
        if(row == n) {
            ans.add(generateList(pos));
            return;
        }
        for(int col = 0; col < n; col++) {
            if(!cols[col] && !skim[row + col] && !restrain[row - col + n]) {
                cols[col] = true;
                skim[row + col] = true;
                restrain[row - col + n] = true;
                pos[row][col] = 'Q';
                backtracking(n, row + 1, pos, cols, skim, restrain, ans);
                pos[row][col] = '.';
                cols[col] = false;
                skim[row + col] = false;
                restrain[row - col + n] = false;
            }
        }
    }

    private List<String> generateList(char[][] pos) {
        List<String> result = new ArrayList<>(pos.length); 
        for(char[] a : pos) {
            StringBuilder s = new StringBuilder();
            for(char c : a) {
                s.append(c != 'Q' ? '.' : 'Q');
            }
            result.add(s.toString());
        }
        return result;
    }
}