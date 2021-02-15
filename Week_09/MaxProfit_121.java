class Solution {
    public int maxProfit(int[] prices) {
        int dp = prices[0];// 从0到i的最小股价
        int max = 0;// 从0到i的最大利润
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > dp) max = Math.max(max, prices[i] - dp);
            dp = dp < prices[i] ? dp : prices[i];
        }
        return max;
    }
}