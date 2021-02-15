class Solution {    
    /**
    * DP
    * DP[i][j][k]: 直到第i天，j是否持有股票，第k笔交易(买入计算)的最大利润
    * State Compression
    */
    public int maxProfit(int K, int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int[][] dp = new int[2][K + 1];
        for(int k = 0; k <= K; k++) {
            dp[1][k] = -prices[0];
        }
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            boolean last = i == prices.length - 1;
            for(int k = 1; k <= K; k++) {
                dp[0][k] = Math.max(dp[0][k], dp[1][k] + prices[i]);
                dp[1][k] = Math.max(dp[1][k], dp[0][k - 1] - prices[i]);
                if(last) max = Math.max(max, dp[0][k]);
            }
        }
        return max;
    }
    
    /**
    * DP
    * DP[i][j][k]: 直到第i天，j是否持有股票，第k笔交易(买入计算)的最大利润
    */
    public int maxProfit1(int K, int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int[][][] dp = new int[prices.length][2][K + 1];
        for(int k = 0; k <= K; k++) {
            dp[0][1][k] = -prices[0];
        }
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            boolean last = i == prices.length - 1;
            for(int k = 1; k <= K; k++) {
                dp[i][0][k] = Math.max(dp[i - 1][0][k], dp[i - 1][1][k] + prices[i]);
                dp[i][1][k] = Math.max(dp[i - 1][1][k], dp[i - 1][0][k - 1] - prices[i]);
                if(last) max = Math.max(max, dp[i][0][k]);
            }
        }
        return max;
    }
}