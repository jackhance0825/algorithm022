class Solution {
    /**
    * 二分法
    */
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for(int num : nums) {
            right += num;
            left = Math.max(left, num);
        }
        while(left < right) {
            int mid = left + (right - left) / 2;
            int split = 1, splitSum = 0;
            for(int num : nums) {
                if((splitSum += num) > mid) {
                    split++;
                    splitSum = num;
                }
            }
            if(split > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
    * DP
    * preSum[i] : 直至i的数组总和
    * dp[i][k] : 直至i的k个子数组各自和的最大值最小
    * dp[i][k] = min(max(dp[j][k - 1], rangeSum(j, i)))
    * 状态压缩，可以发现dp使用一维数组即可
    */
    public int splitArray2(int[] nums, int m) {
        int[] preSum = new int[nums.length + 1];
        int[] dp = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
            dp[i] = preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for(int k = 2; k <= m; k++) {
            for(int i = nums.length; i >= k; i--) {
                int min = Integer.MAX_VALUE;
                for(int j = k - 1; j <= i - 1; j++) {
                    min = Math.min(min, Math.max(dp[j], preSum[i] - preSum[j]));
                }
                dp[i] = min;
            }
        }
        return dp[nums.length];
    }

    /**
    * DP
    * preSum[i] : 直至i的数组总和
    * dp[i][k] : 直至i的k个子数组各自和的最大值最小
    * dp[i][k] = min(max(dp[j][k - 1], rangeSum(j, i)))
    */
    public int splitArray1(int[] nums, int m) {
        int[] preSum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int[][] dp = new int[nums.length + 1][m + 1];
        for(int k = 1; k <= m; k++) {
            for(int i = k; i <= nums.length; i++) {
                int min = Integer.MAX_VALUE;
                if(k > 1) {
                    for(int j = k - 1; j <= i - 1; j++) {
                        min = Math.min(min, Math.max(dp[j][k - 1], preSum[i] - preSum[j]));
                    }
                } else {
                    min = preSum[i];
                }
                dp[i][k] = min;
            }
        }
        return dp[nums.length][m];
    }
}