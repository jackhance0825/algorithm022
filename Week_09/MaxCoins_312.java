class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length + 2;
        // dp[i][j]: i(exclude)到j(exclude)间的最大硬币数
        int[][] dp = new int[n][n];// dp[i][j] = dp[i][k] + nums[i] * nums[k] * nums[j] + dp[k][j]
        for(int i = n - 3; i >= 0; i--) {
            for(int j = i + 2; j < n; j++) {
                int left = i == 0 ? 1 : nums[i - 1];
                int right = j == n - 1 ? 1 : nums[j - 1];
                for(int k = i + 1; k < j; k++) {
                    int mid = nums[k - 1];
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + left * mid * right + dp[k][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}