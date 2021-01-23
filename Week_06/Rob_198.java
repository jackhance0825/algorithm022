class Solution {
    /**
    * DP(压缩空间)
    * DP[i], 直至到第i间，偷或者不偷的最大值
    * DP[i] = max(DP[i - 1], DP[i - 2] + nums[i])
    */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int first = 0;
        int second = nums[0];
        int dp = second;
        for(int i = 2; i <= nums.length; i++) {
            dp = Math.max(second, first + nums[i - 1]);
            first = second;
            second = dp;
        }
        return dp;
    }

    /**
    * DP
    * DP[i], 直至到第i间，偷或者不偷的最大值
    * DP[i] = max(DP[i - 1], DP[i - 2] + nums[i])
    */
    public int rob2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for(int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }


    /**
    * DP
    * DP[i][j], 直至到第i间，偷(j=1)或者不偷(j=0)的最大值
    * DP[i][0] = max(DP[i - 1][1], DP[i - 1][0])
    * DP[i][1] = DP[i - 1][0] + nums[i]
    */
    public int rob1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length + 1][2];
        for(int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}