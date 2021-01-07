class Solution {
    /**
    * greedy，只要当天比前一天价格要高，前一天就买入，当天卖出
    * Time Complexity : O(n)
    * Space Complexity : O(1)
    */
    public int maxProfit(int[] prices) {
        int s = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                s += prices[i] - prices[i - 1];
            }
        }
        return s;
    }
}