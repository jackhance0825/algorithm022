class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int steal1 = 0, unsteal1 = 0, steal2 = 0, unsteal2 = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            // 偷[0, nums.length - 2]
            int unsteal0 = unsteal1;
            unsteal1 = Math.max(steal1, unsteal1);
            steal1 = unsteal0 + nums[i];
            // 偷[1, nums.length - 1]
            unsteal0 = unsteal2;
            unsteal2 = Math.max(steal2, unsteal2);
            steal2 = unsteal0 + nums[i + 1];
        }
        return Math.max(Math.max(steal1, unsteal1), Math.max(steal2, unsteal2));
    }
}