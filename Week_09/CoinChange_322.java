class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++) {
            int min = amount + 1;
            for(int coin : coins) {
                if(i >= coin) min = Math.min(dp[i - coin] + 1, min);
            }
            dp[i] = min;
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}