class Solution {
    /**
    * DP
    * DP[i] ：走到i的最小序号
    * DP[i] = i <= max ? DP[i - 1] : i
    */
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1) return true;
        int[] dp = new int[nums.length];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = i <= max ? dp[i - 1] : i;
            max = Math.max(max, i + nums[i]);
        }
        return dp[nums.length - 1] == 0;
    }
}