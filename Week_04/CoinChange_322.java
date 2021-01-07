class Solution {
	/**
    * DP
    * dp[n] : 总额为n的最少硬币数
    * dp[n] = min(dp[n - coins[k0]], dp[n - coins[k1]], ... ,dp[n - coins[km]]) + 1, (m <= coins.length)
    * dp[0] = 0
    * Time Complexity : O(amount * coins.length)
    * Space Complexity : O(amount)
    */
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int [amount + 1];
        for(int a = 1; a <= amount; a++) {
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < coins.length; i++) {
                if(a - coins[i] >= 0 && dp[a - coins[i]] >= 0) {
                    min = Math.min(min, dp[a - coins[i]] + 1);
                }
            }
            dp[a] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
	
	/**
    * 穷举 + DFS + 剪枝 
    * Time Complexity: O(amount ^ coins.length)
    * Space Complexity: O(amount ^ coins.length)，
    * 最坏情况下，递归层数为 (amount/ coin1) * (amount/ coin2) * ... * (amount/ coinn) = (amount ^ n)/ (coin0 * coin1 * ... coinn)
    */
    int min = Integer.MAX_VALUE;
    public int coinChange1(int[] coins, int amount) {
        if(amount == 0) return 0;
        Arrays.sort(coins);
        coinChange(coins, amount, coins.length - 1, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void coinChange(int[] coins, int amount, int index, int num) {
        if(amount == 0 || index < 0) {
            min = Math.min(min, amount == 0 ? num : Integer.MAX_VALUE);
            return;
        }
        for(int i = amount / coins[index]; i >= 0 && min > num + i; i--) {
            coinChange(coins, amount - i * coins[index], index - 1, num + i);
        }
    }
}