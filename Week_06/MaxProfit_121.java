class Solution {
    /**
    * DP
    * DP[i]: 直至到第i天的最低价格
    * DP[i] = min(price[i], DP[i - 1])
    * 优化
    */
    public int maxProfit(int[] prices) {
        int dp = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            int v = prices[i] - dp;
            if(v < 0) {
                dp = prices[i];
            } else if(v > max) {
                max = v;
            } 
        }
        return max;
    }

    /**
    * DP
    * DP[i]: 直至到第i天的最低价格
    * DP[i] = min(price[i], DP[i - 1])
    */
    public int maxProfit1(int[] prices) {
        int[] dp = prices;
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i] - dp[i - 1], max);
            dp[i] = Math.min(dp[i - 1], prices[i]);
        }
        return max;
    }
}