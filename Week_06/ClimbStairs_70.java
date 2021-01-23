class Solution {
    /**
    * DP
    * DP[i] : 走到第i个台阶的方法数
    * DP[i] = DP[i - 1] + DP[i - 2]
    * 压缩空间复杂度
    */
    public int climbStairs(int n) {
        int first = 1;
        int second = 1;
        int dp = second;
        for(int i = 2; i <= n; i++) {
            dp = first + second;
            first = second;
            second = dp;
        }
        return dp;
    }
    
    /**
    * DP
    * DP[i] : 走到第i个台阶的方法数
    * DP[i] = DP[i - 1] + DP[i - 2]
    */
    public int climbStairs3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
    * memorized recursive
    * TimeComplexity: O(2^n)
    * SpaceComplexity: O(n)
    */
    public int climbStairs2(int n) {
        int[] memorized = new int[n + 1];
        return memorizedClimbStairs(n, memorized);
    }

    private int memorizedClimbStairs(int n, int[] memorized) {
        if(n <= 1) return memorized[n] = 1;
        if(memorized[n] > 0) return memorized[n];
        return memorized[n] = memorizedClimbStairs(n - 1, memorized) + memorizedClimbStairs(n - 2, memorized);
    }

    /**
    * naive recursive
    * TimeComplexity: O(2^n)
    * SpaceComplexity: O(n)
    */
    public int climbStairs1(int n) {
        return n <= 1 ? 1 : climbStairs(n - 1) + climbStairs(n - 2);
    }
}