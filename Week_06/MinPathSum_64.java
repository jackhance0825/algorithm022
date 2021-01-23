class Solution {
    /**
    * DP
    * DP[i][j], 从终点(m - 1,n - 1)走到(i,j)的最短路径
    * DP[i][j] = min(DP[i + 1][j], DP[i][j + 1]) + grid[i][j]
    */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = grid;
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1) {
                    dp[i][j] += j == n - 1 ? 0 : dp[i][j + 1];
                } else {
                    dp[i][j] += j == n - 1 ? dp[i + 1][j] : Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
    
    /**
    * DP
    * DP[i][j], 从(0,0)走到(i,j)的最短路径
    * DP[i][j] = min(DP[i - 1][j], DP[i][j - 1]) + grid[i][j]
    */
    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = grid;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0) {
                    dp[i][j] += j == 0 ? 0 : dp[i][j - 1];
                } else {
                    dp[i][j] += j == 0 ? dp[i - 1][j] : Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}