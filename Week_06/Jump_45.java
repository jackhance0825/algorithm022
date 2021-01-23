class Solution {
    /**
    * DP
    * DP[i][j] ：走到i的状态 （0-最少步数， 1-当前步的最大位置，2-当前能跳跃的最大位置）
    * DP[i][2] = max(DP[i - 1][2], i + nums[i]);
    * DP[i][1] = i < DP[i - 1][1] ? DP[i - 1][1] ：DP[i][2]
    * DP[i][0] = i > DP[i - 1][1] ? DP[i - 1][0] + 1 : DP[i - 1][0]
    */
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        int[][] dp = new int[nums.length][3];
        dp[0][1] = dp[0][2] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i][2] = Math.max(dp[i - 1][2], i + nums[i]);
            dp[i][1] = i < dp[i - 1][1] ? dp[i - 1][1] : dp[i][2];
            dp[i][0] = i >= dp[i - 1][1] || i == nums.length - 1 ? dp[i - 1][0] + 1 : dp[i - 1][0];
        }
        return dp[nums.length - 1][0];
    }
}