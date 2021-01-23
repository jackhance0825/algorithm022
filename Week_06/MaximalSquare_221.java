class Solution {
    /**
    * DP
    * DP[i][j]：右下角为坐标(i, j)的全1正方形最大边长
    * DP[i][j] = matrix[i][j] == '0' ? 0 : min(DP[i - 1][j], DP[i][j - 1], DP[i - 1][j - 1]) + 1
    */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp0 = new int[n + 1];
        int[] dp = new int[n + 1];
        int max = 0;
        for(int i = 1; i <= m; i++) {
            int[] temp = dp;
            dp = dp0;
            dp0 = temp;
            for(int j = 1; j <= n; j++) {
                if(matrix[i - 1][j - 1] == '0') {
                    dp[j] = 0;
                } else {
                    dp[j] = Math.min(dp0[j], Math.min(dp0[j - 1], dp[j - 1])) + 1;
                    max = Math.max(dp[j], max);
                }
            }
        }
        return max * max;
    }

    /**
    * DP
    * DP[i][j]：右下角为坐标(i, j)的全1正方形最大边长
    * DP[i][j] = matrix[i][j] == '0' ? 0 : min(DP[i - 1][j], DP[i][j - 1], DP[i - 1][j - 1]) + 1
    */
    public int maximalSquare1(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(matrix[i - 1][j - 1] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    max = Math.max(dp[i][j], max);
                } 
            }
        }
        return max * max;
    }
}