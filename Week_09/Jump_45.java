class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        int step = 1;// 第几步
        int max = nums[0];// 步伐最大跨度
        int pos = max;// 当前步的最大位置
        for(int i = 1; i < nums.length; i++) {
            if(pos + 1 == i) {// 下一个步跨
                step++;
                pos = max;
            }
            max = Math.max(max, nums[i] + i);
        }
        return step;
    }
}