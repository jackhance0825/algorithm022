class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1) return true;
        int max = nums[0];
        for(int i = 1; i < nums.length && i <= max; i++) {
            max = Math.max(max, nums[i] + i);
            if(max >= nums.length - 1) return true;
        }
        return false;
    }
}