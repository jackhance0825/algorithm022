class Solution {
    /**
    * DP
    * DP[i] : 从0到i包含i的连续子数组最大和
    * DP[i] = max(DP[i - 1] + nums[i], nums[i])
    * 压缩空间复杂度
    */
    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int max = nums[0];
        for(int i = 2; i <= nums.length; i++) {
            dp = Math.max(dp, 0) + nums[i - 1];
            max = Math.max(dp, max);
        }
        return max;
    }

    /**
    * DP
    * DP[i] : 从0到i包含i的连续子数组最大和
    * DP[i] = max(DP[i - 1] + nums[i], nums[i])
    */
    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i - 1];
            dp[0] = i == 1 ? dp[i] : Math.max(dp[0], dp[i]);
        }
        return dp[0];
    }
}