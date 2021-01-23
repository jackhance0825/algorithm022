class Solution {
    /**
    * DP
    * DP[i][j] = DP[i - 1][j] + (j - coins[i] >= 0 ? DP[i][j - coins[i]] : 0)
    * 观察状态转移方程，可以直接使用一维状态重复迭代，从而压缩空间复杂度
    * DP[j] += DP[j - coin[i]], (coin[i] <= j <= amount)
    * TimeComplexity：O(amount * coins.length)
    * SpaceComplexity: O(amount)
    */
    public int change(int amount, int[] coins) {
        if(amount < 0) return 0;
        if(amount == 0) return 1;
        if(coins == null || coins.length == 0) return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins) {
            for(int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
    
    /**
    * DP
    * DP[i][j] : 使用前i种硬币凑成总金额为j的方案数
    * DP[i][0] = 1, 总金额为0，不用凑，方案数为1
    * DP[i][j] = DP[i - 1][j] + (j - coins[i] >= 0 ? DP[i][j - coins[i]] : 0)
    * 使用前i种硬币，分为俩种情况，使用和不使用，总方案数为俩种情况之和。
    * 若使用时，当前总金额必须不小于coins[i]；
    * 若不使用时，则为上一种桶金额的方案数
    * TimeComplexity：O(amount * coins.length)
    * SpaceComplexity: O(amount * coins.length)
    */
    public int change1(int amount, int[] coins) {
        if(amount < 0) return 0;
        if(amount == 0) return 1;
        if(coins == null || coins.length == 0) return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 1; i <= coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                if(j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + (j - coins[i - 1] >= 0 ? dp[i][j - coins[i - 1]] : 0);
                }
            }
        }
        return dp[coins.length][amount];
    }
}