class Solution {
    /**
    * DP
    * 
    * DP状态：
    * notOwnNotSell-不持有且当天未卖出
    * notOwnSell-不持有且当天卖出
    * own-持有
    * 
    * DP方程：
    * notOwnNotSell = max(notOwnNotSell, notOwnSell)
    * notOwnSell = own + prices[i]
    * own = max(own, notOwnNotSell - prices[i])
    */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int notOwnNotSell = 0, notOwnSell = 0, own = -prices[0], temp = 0;
        for(int i = 1; i < prices.length; i++) {
            notOwnNotSell = Math.max(temp = notOwnNotSell, notOwnSell);
            own = Math.max(temp - prices[i], temp = own);
            notOwnSell = temp + prices[i];
        }
        return Math.max(notOwnNotSell, notOwnSell);
    }
    
    /**
    * DP
    * DP[i][j]: 第i天 & 是否持有（0-不持有且当天未卖出, 1-不持有且当天卖出, 2-持有) 的最大利润
    * DP[i][0] = max(DP[i - 1][0], DP[i - 1][1])
    * DP[i][1] = DP[i - 1][2] + prices[i]
    * DP[i][2] = max(DP[i - 1][2], DP[i - 1][0] - prices[i])
    */
    public int maxProfit1(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int[][] dp = new int[prices.length][3];
        dp[0][2] = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][2] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] - prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}