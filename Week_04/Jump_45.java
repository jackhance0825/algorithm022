class Solution {
    /**
    * greedy: 最大步长区域内的最小步数都是一致的，因此跨越区域时，步数+1即可
    * Time Complexity: O(n), n为nums.length
    */
    public int jump(int[] nums) {
        int pos = 0;
        int max = 0;
        int step = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            max = Math.max(i + nums[i], max);
            if(pos == i) {
                pos = max;
                step++;
            }
        }
        return step;
    }
}