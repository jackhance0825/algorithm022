class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n + 1];
        dp[n - 1] = 1;
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                dp[j] += dp[j + 1];
            }
        }
        return dp[0];
    }

    public int uniquePaths3(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n - 1] = 1;
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
        return dp[0][0];
    }
    
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n];
    }
    
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m][n];
    }
}