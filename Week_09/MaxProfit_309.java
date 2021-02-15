class Solution {
    /**
    * DP[i][j] : 直到第i天，j(0-拥有，1-不拥有&当天未卖出，2-不拥有&当天卖出)的最大利润
    * State Compression
    */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int own = -prices[0], notOwnNotSell = 0, notOwnSell = 0;
        for(int i = 1; i < prices.length; i++) {
            int own0 = own;
            int notOwnNotSell0 = notOwnNotSell;
            int notOwnSell0 = notOwnSell;
            own = Math.max(own0, notOwnNotSell0 - prices[i]);
            notOwnNotSell = Math.max(notOwnNotSell0, notOwnSell0);
            notOwnSell = own0 + prices[i];
        }
        return Math.max(notOwnNotSell, notOwnSell);
    }
    
    /**
    * DP[i][j] : 直到第i天，j(0-拥有，1-不拥有&当天未卖出，2-不拥有&当天卖出)的最大利润
    */
    public int maxProfit1(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}