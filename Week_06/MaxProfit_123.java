class Solution {
    /**
    * DP
    * DP过程存在5个状态：
    * 什么都不操作
    * buy1(购买一次) = max(buy1, -prices[i])
    * sell1(卖出一次) = max(sell1, buy1 + prices[i])
    * buy2(买入第二次) = max(buy2, sell1 - prices[i])
    * sell2(卖出第二次) = max(sell2, buy2 + prices[i])
    */
    public int maxProfit(int[] prices) {
        int buy1 = -prices[0], buy2 = -prices[0], sell1 = 0, sell2 = 0;
        for(int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, - prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return Math.max(0, Math.max(sell1, sell2));
    }
    
    /**
    * DP
    * DP[i][j][k] : 第i天 & 是否持有股票(0-不持有，1-持有) & 完成第k笔 的最大利润 
    * DP[i][0][k] = max(DP[i - 1][0][k], DP[i - 1][1][k - 1] + prices[i])
    * DP[i][1][k] = max(DP[i - 1][1][k], DP[i - 1][0][k] - prices[i])
    * 优化空间复杂度
    */
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[2][3];
        dp[1][0] = dp[1][1] = dp[1][2] = -prices[0];
        for(int i = 2; i <= prices.length; i++) {
            for(int k = 0; k < 3; k++) {
                int dp0k = dp[0][k];
                dp[0][k] = k == 0 ? 0 : Math.max(dp0k, dp[1][k - 1] + prices[i - 1]);
                dp[1][k] = Math.max(dp[1][k], dp0k - prices[i - 1]);
            }
        }
        return Math.max(0, Math.max(dp[0][1], dp[0][2]));
    }

    /**
    * DP
    * DP[i][j][k] : 第i天 & 是否持有股票(0-不持有，1-持有) & 完成第k笔 的最大利润 
    * DP[i][0][k] = max(DP[i - 1][0][k], DP[i - 1][1][k - 1] + prices[i])
    * DP[i][1][k] = max(DP[i - 1][1][k], DP[i - 1][0][k] - prices[i])
    */
    public int maxProfit1(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][3];
        dp[1][1][0] = dp[1][1][1] = dp[1][1][2] = -prices[0];
        for(int i = 2; i <= prices.length; i++) {
            for(int k = 0; k < 3; k++) {
                dp[i][0][k] = k == 0 ? 0 : Math.max(dp[i - 1][0][k], dp[i - 1][1][k - 1] + prices[i - 1]);
                dp[i][1][k] = Math.max(dp[i - 1][1][k], dp[i - 1][0][k] - prices[i - 1]);
            }
        }
        return Math.max(0, Math.max(dp[prices.length][0][1], dp[prices.length][0][2]));
    }
}