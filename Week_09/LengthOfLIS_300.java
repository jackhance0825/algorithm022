class Solution {
    /**
    * Greedy + BS
    * Time Complexity: O(nlogn)
    */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];// 记录最长子序列
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = max;// exclude
            while(left < right) {
                int mid = left + ((right - left) >> 1);
                if(nums[i] > dp[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = nums[i];// 记录最长子序列
            if(left == max) max++;// 当前值比原最长子序列各值都大，长度+1
        }
        return max;
    }
    
    /**
    * Time Complexity: O(n ^ 2)
    */
    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];// 使用i结尾的最长子序列长度
        dp[0] = 1;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            int max0 = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] < nums[i]) {// 只要前者比当前i小，则满足+1，取最大值
                    max0 = Math.max(max0, dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i] = max0);
        }
        return max;
    }
}