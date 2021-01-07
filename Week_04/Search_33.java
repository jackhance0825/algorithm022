class Solution {
    /**
    * 二分法
    * Time Complexity: O(logN), N为nums.length
    * Space Complexity: O(1)
    */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(right >= left) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] >= nums[left]) {// 左区域升序
                if(target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {// 右区域升序
                if(target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}