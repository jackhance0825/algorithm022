class Solution {
    /**
    * 二分法
    * Time Complexity: O(logN), N为nums.length
    * Space Complexity: O(1)
    */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[left]) {// mid < left,即左区域存在旋转点
                right = mid;
            } else {// mid >= left，即左区域升序
                if(nums[right] > nums[left]) {// 左右界内升序，left为最小值
                    right = left;
                } else {// 右区域存在旋转点
                    left = left == mid ? right : mid;
                }
            }
        }
        return nums[left];
    }
}