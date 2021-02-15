class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int steal = 0;// i位置偷，从0到i的最大金额
        int unsteal = 0;// i位置不偷，从0到i的最大金额
        for(int i = 0; i < nums.length; i++) {
            int unsteal0 = unsteal;
            unsteal = Math.max(steal, unsteal);
            steal = unsteal0 + nums[i];
        }
        return Math.max(steal, unsteal);
    }
}