class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int dp0 = -1;// 最大正数
        int dp1 = 1;// 最小负数
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0) {
                dp0 = Math.max(nums[i] , dp0 * nums[i]);
                dp1 = dp1 * nums[i];
            } else {
                int temp = dp1;
                dp1 = Math.min(nums[i] , dp0 * nums[i]);
                dp0 = temp * nums[i];
            }
            max = Math.max(dp0, max);
        }
        return max;
    }
}