class Solution {
    /**
    * DP
    * DP[i] ：总额为i的最少币数
    * DP[i] = min(DP[i - coins[0]], DP[i - coins[1], ...,DP[i - coins[C - 1]]) + 1
    * 时间复杂度为O(N*C)，N为总额，C为面额种类数
    * 空间复杂度为O(N)
    */
    public int coinChange(int[] coins, int amount) {
        if(amount <= 0) return 0;
        if(coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++) {
            int min = amount + 1;
            for(int coin : coins) {
                if(i - coin >= 0) {
                    min = Math.min(min, dp[i - coin] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[amount] >= amount + 1 ? -1 : dp[amount];
    }
}