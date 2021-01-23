class Solution {
    /**
    * DP
    * DP[i][j]: 到第i天是否持有股票的最大收益
    * 不持有股票：DP[i][0] = max(DP[i - 1][0], DP[i - 1][1] + prices[i])
    * 持有股票：DP[i][1] = max(DP[i - 1][1], DP[i - 1][0] - prices[i])
    */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][1] = -prices[0];
        for(int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }
        return dp[prices.length][0];
    }

    /**
    * greedy
    * 只要后一天的价格比当天价格高，就在当天买入，后一天卖出
    */
    public int maxProfit1(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            int m = prices[i] - prices[i - 1];
            if(m > 0) max += m;
        }
        return max;
    }
}