class Solution {
    /**
    * DP[i][j]: 从终点(m - 1, n - 1) 走到 (i,j)的路径数
    * DP[i][j] = 障碍？0 : dp[i + 1][j] + dp[i][j + 1]
    * 状态压缩
    */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n + 1];
        dp[n - 1] = 1;
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j] + dp[j + 1];
            }
        }
        return dp[0];
    }

    /**
    * DP[i][j]: 从终点(m - 1, n - 1) 走到 (i,j)的路径数
    * DP[i][j] = 障碍？0 : dp[i + 1][j] + dp[i][j + 1]
    */
    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n - 1] = 1;
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    /**
    * DP[i][j]: 从起点(1, 1) 走到 (i,j)的路径数
    * DP[i][j] = 障碍？0 : dp[i - 1][j] + dp[i][j - 1]
    * 状态压缩
    */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[j] = obstacleGrid[i - 1][j - 1] == 1 ? 0 : dp[j] + dp[j - 1];
            }
        }
        return dp[n];
    }
    
    /**
    * DP[i][j]: 从起点(1, 1) 走到 (i,j)的路径数
    * DP[i][j] = 障碍？0 : dp[i - 1][j] + dp[i][j - 1]
    */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = obstacleGrid[i - 1][j - 1] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}