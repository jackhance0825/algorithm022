class Solution {
    /**
    * DP[i] : 直至到第i间，偷或者不偷的最高金额（暂不考虑环问题）
    * DP[i] = max(DP[i - 1], DP[i - 2] + nums[i])
    * 结果：max(DP[nums.length - 1] (忽略最后1间), DP[nums.length]（忽略第1间）)
    */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 1, nums.length - 1), rob(nums, 2, nums.length));
    }

    private int rob(int[] nums, int s, int e) {
        if(s > e) return 0;
        if(s == e) return nums[e - 1]; 
        int first = 0;
        int second = nums[s - 1];
        for(int i = s + 1; i <= e; i++) {
            second = Math.max(first + nums[i - 1], first = second);
        }
        return second;
    }
}