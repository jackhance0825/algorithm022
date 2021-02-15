class Solution {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int step = 1;
        int srcX = -1;
        int srcY = -1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    srcX = i;
                    srcY = j;
                } else if(grid[i][j] != -1) {
                    step++;
                }
            }
        }
        return dfs(grid, srcX, srcY, m, n, step);
    }

    private int dfs(int[][] grid, int x, int y, int m, int n, int step) {
        if(x < 0 || x >= m || y < 0 || y >= n) return 0;
        if(step-- < 0 || grid[x][y] == -1) return 0;
        if(grid[x][y] == 2) return step == 0 ? 1 : 0;
        grid[x][y] = -1;
        int res = dfs(grid, x + 1, y, m, n, step);
        res += dfs(grid, x - 1, y, m, n, step);
        res += dfs(grid, x, y - 1, m, n, step);
        res += dfs(grid, x, y + 1, m, n, step);
        grid[x][y] = 0;
        return res;
    }
}