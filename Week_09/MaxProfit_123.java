class Solution {
    /**
    * DP
    * DP[i][j][k]: 直到第i天，j是否持有股票，第k笔交易(买入计算)的最大利润
    * State Compression
    */
    public int maxProfit(int[] prices) {
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for(int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return Math.max(0, Math.max(sell1, sell2));
    }
    
    /**
    * DP
    * DP[i][j][k]: 直到第i天，j是否持有股票，第k笔交易(买入计算)的最大利润
    * State Compression
    */
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[2][3];
        dp[1][0] = dp[1][1] = dp[1][2] = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            for(int k = 1; k <= 2; k++) {
                dp[0][k] = Math.max(dp[0][k], dp[1][k] + prices[i]);
                dp[1][k] = Math.max(dp[1][k], dp[0][k - 1] - prices[i]);
            }
        }
        return Math.max(0, Math.max(dp[0][1], dp[0][2]));
    }
    
    /**
    * DP
    * DP[i][j][k]: 直到第i天，j是否持有股票，第k笔交易(买入计算)的最大利润
    */
    public int maxProfit1(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        dp[0][1][0] = dp[0][1][1] = dp[0][1][2] = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            for(int k = 1; k <= 2; k++) {
                dp[i][0][k] = Math.max(dp[i - 1][0][k], dp[i - 1][1][k] + prices[i]);
                dp[i][1][k] = Math.max(dp[i - 1][1][k], dp[i - 1][0][k - 1] - prices[i]);
            }
        }
        return Math.max(0, Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]));
    }
}