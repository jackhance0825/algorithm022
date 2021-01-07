class Solution {
    /**
    * DFS
    * Time Complexity: O(m * n), m为grid.length, n为grid[i].length
    * Space Complexity: O(m * n), m为grid.length, n为grid[i].length，最坏情况，全部为1，dfs递归深度为m*n
    */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int s = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != '0') {
                    s++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return s;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i, j - 1, m, n);
    }
}