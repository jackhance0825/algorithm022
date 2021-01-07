class Solution {
    /**
    * DP
    * dp[i]: 第i天的最大利润
    * dp[0] = 0
    * dp[n] = dp[n - 1] + (prices[n] > prices[n - 1] ? prices[n] - prices[n - 1] : 0)
    * Time Complexity : O(n), n为prices.length
    * Space Complexity: O(n)
    */
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        for(int i = 1; i < prices.length; i++) {
            dp[i] = dp[i - 1] + (prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0);
        }
        return dp[prices.length - 1];
    }
}