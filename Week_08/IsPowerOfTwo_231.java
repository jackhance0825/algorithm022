class Solution {
	// 取最后一位是否等于自身
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & -n) == n;
    }
    
	// 打掉最后一位
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}