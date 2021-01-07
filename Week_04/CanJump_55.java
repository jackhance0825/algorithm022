class Solution {
    /**
    * greedy, 当num[i] + i >= min，即前面的位置能到达min的位置，每次记录最前的位置，以此类推，可以跳过整个nums
    * Time Complexity: O(n)
    * Space Complexity: O(1)
    */
    public boolean canJump(int[] nums) {
        int min = nums.length - 1;
        for(int i = min - 1; i >= 0; i--) {
            if(nums[i] >= min - i) {
                min = i;
            }
        }
        return min == 0;
    }
}