class Solution {
    /**
    * DP
    * dp[i][j]：区间[i, j]的获得硬币最大数量
    * i + 1 < j  时: dp[i][j] = max(dp[i][k] + dp[k][j] + nums[i] * nums[k] * nums[j]), i < k < j
    * i + 1 >= j 时: 0
    */
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length + 2, left = 0, right = 0;
        int[][] dp = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            left = i == 0 ? 1 : nums[i - 1];
            for (int j = i + 2; j < n; j++) {
                right = j == n - 1 ? 1 : nums[j - 1];
                int max = 0;
                for (int k = i + 1; k < j; k++) {
                    max = Math.max(max, left * nums[k - 1] * right + dp[i][k] + dp[k][j]);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n - 1];
    }
}