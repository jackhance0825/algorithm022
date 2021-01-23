class Solution {
    /**
    * DP[i][j], 从(i, j) 到终点的路径数
    * DP[i][j] = DP[i + 1][j] + DP[i][j + 1]
    * 压缩空间
    */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[n - 1] = 1;
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                dp[j] += dp[j + 1];
            }
        }
        return dp[0];
    }

    /**
    * DP[i][j], 从(i, j) 到终点的路径数
    * DP[i][j] = DP[i + 1][j] + DP[i][j + 1]
    */
    public int uniquePaths3(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 || j == n - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    /**
    * DP[i][j], 从start到（i, j）的路径数
    * DP[i][j] = DP[i - 1][j] + DP[i][j - 1]
    * 压缩空间
    */
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    /**
    * DP[i][j], 从start到（i, j）的路径数
    * DP[i][0] = 1
    * DP[0][j] = 1
    * DP[i][j] = DP[i - 1][j] + DP[i][j - 1]
    */
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}