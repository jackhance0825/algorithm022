class Solution {
    /**
    * DP
    * DP[j][k] : 第i天 & 是否持有股票(0-不持有，1-持有) & 完成第k笔 的最大利润 
    * DP[0][k] = max(DP[0][k], DP[1][k - 1] + prices[i])
    * DP[1][k] = max(DP[1][k], DP[0][k] - prices[i])
    */
    public int maxProfit(int K, int[] prices) {
        if(prices == null || prices.length == 0 || K <= 0) return 0;
        int[][] dp = new int[2][K + 1];
        for(int k = 0; k <= K; k++) {
            dp[1][k] = -prices[0];
        }
        int max = 0;
        for(int i = 2; i <= prices.length; i++) {
            boolean isLast = i == prices.length;
            for(int k = 0; k <= K; k++) {
                int dp0k = dp[0][k];
                dp[0][k] = k == 0 ? 0 : Math.max(dp0k, dp[1][k - 1] + prices[i - 1]);
                dp[1][k] = Math.max(dp[1][k], dp0k - prices[i - 1]);
                if(isLast) max = Math.max(max, dp[0][k]);
            }
        }
        return max;
    }

    /**
    * DP
    * DP[i][j][k] : 第i天 & 是否持有股票(0-不持有，1-持有) & 完成第k笔 的最大利润 
    * DP[i][0][k] = max(DP[i - 1][0][k], DP[i - 1][1][k - 1] + prices[i])
    * DP[i][1][k] = max(DP[i - 1][1][k], DP[i - 1][0][k] - prices[i])
    */
    public int maxProfit1(int K, int[] prices) {
        if(prices == null || prices.length == 0 || K <= 0) return 0;
        int[][][] dp = new int[prices.length + 1][2][K + 1];
        for(int k = 0; k <= K; k++) {
            dp[1][1][k] = -prices[0];
        }
        int max = 0;
        for(int i = 2; i <= prices.length; i++) {
            boolean isLast = i == prices.length;
            for(int k = 0; k <= K; k++) {
                dp[i][0][k] = k == 0 ? 0 : Math.max(dp[i - 1][0][k], dp[i - 1][1][k - 1] + prices[i - 1]);
                dp[i][1][k] = Math.max(dp[i - 1][1][k], dp[i - 1][0][k] - prices[i - 1]);
                if(isLast) max = Math.max(max, dp[i][0][k]);
            }
        }
        return max;
    }
}