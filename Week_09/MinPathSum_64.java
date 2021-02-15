class Solution {
    /**
    * dp[i][j] : 从终点(m - 1,n - 1)走到(i,j)的最小路径和
    * 状态压缩
    */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 || j == n - 1) {
                    dp[j] = dp[j] + dp[j + 1] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + grid[i][j];
                }
            }
        }
        return dp[0];
    }
    
    /**
    * dp[i][j] : 从终点(m - 1,n - 1)走到(i,j)的最小路径和
    */
    public int minPathSum3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 || j == n - 1) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    /**
    * dp[i][j] : 从起点(1,1)走到(i,j)的最小路径和
    * 状态压缩
    */
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == 1 || j == 1) {
                    dp[j] = dp[j] + dp[j - 1] + grid[i - 1][j - 1];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i - 1][j - 1];
                }
            }
        }
        return dp[n];
    }

    /**
    * dp[i][j] : 从起点(1,1)走到(i,j)的最小路径和
    */
    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == 1 || j == 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + grid[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}