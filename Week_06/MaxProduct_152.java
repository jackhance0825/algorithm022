class Solution {
    /**
    * DP
    * DP[i][j] : 使用i角标的子数组的最大乘积, DP[i][0]最大正，DP[i][1]最大负
    * DP[i][0] = nums[i] > 0 ? max(DP[i - 1][0] * nums[i], nums[i]) : DP[i - 1][1] * nums[i]
    * DP[i][1] = nums[i] > 0 ? DP[i - 1][1] * nums[i] : min(DP[i - 1][0] * nums[i], nums[i])
    * 压缩空间复杂度
    */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int positive = -1;
        int negative = 1;
        for(int i = 1; i <= nums.length; i++) {
            if(nums[i - 1] > 0) {
                positive = Math.max(positive * nums[i - 1], nums[i - 1]);
                negative = negative * nums[i - 1];
            } else {
                int temp = positive;
                positive = negative * nums[i - 1];
                negative = Math.min(temp * nums[i - 1], nums[i - 1]);
            }
            max = Math.max(positive, max);
        }
        return max;
    }

    /**
    * DP
    * DP[i][j] : 使用i角标的子数组的最大乘积, DP[i][0]最大正，DP[i][1]最大负
    * DP[i][0] = nums[i] > 0 ? max(DP[i - 1][0] * nums[i], nums[i]) : DP[i - 1][1] * nums[i]
    * DP[i][1] = nums[i] > 0 ? DP[i - 1][1] * nums[i] : min(DP[i - 1][0] * nums[i], nums[i])
    */
    public int maxProduct1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[nums.length + 1][2];
        dp[0][0] = -1;
        dp[0][1] = 1;
        for(int i = 1; i <= nums.length; i++) {
            if(nums[i - 1] > 0) {
                dp[i][0] = Math.max(dp[i - 1][0] * nums[i - 1], nums[i - 1]);
                dp[i][1] = dp[i - 1][1] * nums[i - 1];
            } else {
                dp[i][0] = dp[i - 1][1] * nums[i - 1];
                dp[i][1] = Math.min(dp[i - 1][0] * nums[i - 1], nums[i - 1]);
            }
            max = Math.max(dp[i][0], max);
        }
        return max;
    }
}