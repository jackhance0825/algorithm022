class Solution {
    /**
    * greedy
    */
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            res += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        }
        return res;
    }

    /**
    * DP
    */
    public int maxProfit1(int[] prices) {
        int own = -prices[0], notown = 0;
        for(int i = 1; i < prices.length; i++) {
            int notown0 = notown;
            int own0 = own;
            notown = Math.max(own0 + prices[i], notown0);// 直到第i天不持有股票最大值
            own = Math.max(notown0 - prices[i], own0);// 直到第i天持有股票的最大值
        }
        return notown;
    }
}