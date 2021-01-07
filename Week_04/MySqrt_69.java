class Solution {
    /**
    * 二分查找
    * Time Complexity: O(logx)
    * Space Complexity: O(1)
    */
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int left = 1;
        int right = x;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int a = x / mid;
            if(a == mid || mid == left) {
                return mid;
            } else if(a < mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }
}