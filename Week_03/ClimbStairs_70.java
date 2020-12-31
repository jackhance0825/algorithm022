class Solution {
    /**
    * f(0) = 1
    * f(1) = 1
    * f(2) = 2
    * f(3) = 3
    * ...
    * f(n) = f(n - 1) + f(n - 2)
    */

    // 简化DP
    // 时间复杂度O(n)
    // 空间复杂度O(1)
    public int climbStairs(int n) {
        int first = 1, second = 1;
        int f = 1;
        for(int i = 2; i <= n; i++) {
            f = first + second;
            first = second;
            second = f;
        }
        return f;
    }

    // DP
    // f[n] : 走到台阶n的方法数
    // f[n] = f[n - 1] + f[n - 2]
    // f[0] = f[1] = 1
    // 时间复杂度O(n)
    // 空间复杂度O(n)
    public int climbStairs2(int n) {
        int[] f = new int[n + 5];
        f[0] = f[1] = 1;
        for(int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    // 暴力递归
    // 时间复杂度O(2^n)
    public int climbStairs1(int n) {
        if(n <= 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}