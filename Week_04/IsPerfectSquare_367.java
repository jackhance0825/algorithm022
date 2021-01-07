class Solution {
    /**
    * 二分法
    * Time Complexity: O(logN), N为num大小
    * Space Complexity：O(1)
    */
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(num / mid == mid) {
                return num % mid == 0;
            } else if(num / mid > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}