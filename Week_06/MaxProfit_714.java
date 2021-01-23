class Solution {
    /**
    * DP
    * 状态：
    * own-持有股票的最大利润
    * notOwn-不持有股票的最大利润
    *
    * DP方程：
    * notOwn = max(notOwn, own + prices[i])
    * own = max(own, notOwn - prices[i] - fee)
    */
    public int maxProfit(int[] prices, int fee) {
        int own = -prices[0] - fee, notOwn = 0, temp = 0;
        for(int i = 1; i < prices.length; i++) {
            notOwn = Math.max(temp = notOwn, own + prices[i]);
            own = Math.max(own, temp - prices[i] - fee);
        }
        return notOwn;
    }
    
    /**
    * DP
    * DP[i][j] : 第i天 & 是否持有股票(0-不持有, 1-持有)的最大利润
    * DP[i][0] = max(DP[i - 1][0], DP[i - 1][1] + prices[i])
    * DP[i][1] = max(DP[i - 1][1], DP[i - 1][0] - prices[i] - fee)
    */
    public int maxProfit1(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0] - fee;
        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[prices.length - 1][0];
    }
}