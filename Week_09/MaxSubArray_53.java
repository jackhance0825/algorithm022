class Solution {
    public int maxSubArray(int[] nums) {
        int dp = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            dp = Math.max(nums[i] + dp, nums[i]);
            max = Math.max(max, dp);
        }
        return max;
    }
}