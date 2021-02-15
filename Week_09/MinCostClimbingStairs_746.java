class Solution {
    /**
    * State Compression
    */
    public int minCostClimbingStairs(int[] cost) {
        int first = cost[0];
        int second = cost[1];
        for(int i = 2; i < cost.length; i++) {
            second = Math.min(first, first = second) + cost[i];
        }
        return Math.min(first, second);
    }


    public int minCostClimbingStairs1(int[] cost) {
        int[] dp = new int[cost.length];// 走到i的最小花费
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}