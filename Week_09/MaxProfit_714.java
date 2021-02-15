class Solution {
    // State Compression
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length <= 1) return 0;
        int own = -prices[0] - fee, notOwn = 0;
        for(int i = 1; i < prices.length; i++) {
            int own0 = own;
            int notOwn0 = notOwn;
            notOwn = Math.max(notOwn0, own0 + prices[i]);
            own = Math.max(own0, notOwn0 - prices[i] - fee);
        }
        return notOwn;
    }
    
    public int maxProfit1(int[] prices, int fee) {
        if(prices == null || prices.length <= 1) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0] - fee;
        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);// 不持有股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);// 持有股票
        }
        return dp[prices.length - 1][0];
    }
}