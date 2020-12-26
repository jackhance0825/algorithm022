class Solution {
    /**
    * 暴力
    * 时间复杂度O(n^2)
    * 空间复杂度O(1)
    */
    public int[] twoSum1(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == target - nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
    * 哈希表
    * 时间复杂度O(n)
    * 空间复杂度O(n)
    */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if(index != null) {
                return new int[]{index, i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
