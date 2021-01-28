class Solution {
    /**
    * DP
    * TimeComplexity: O(n)
    * State Compression
    */
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        int first = 1, second = 1, res = 1;
        for(int i = 2; i <= n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }

    /**
    * DP
    * TimeComplexity: O(n)
    */
    public int climbStairs3(int n) {
        if(n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
    * Memorized Recursive
    * TimeComplexity: O(n)
    */
    public int climbStairs2(int n) {
        int[] memorized = new int[n + 1];
        memorized[0] = memorized[1] = 1;
        return dfs(memorized, n);
    }

    private int dfs(int[] memorized, int n) {
        if(memorized[n] > 0) return memorized[n];
        return memorized[n] = dfs(memorized, n - 1) + dfs(memorized, n - 2);
    }

    /**
    * Naive Recursive
    * TimeComplexity: O(2^n)
    */
    public int climbStairs1(int n) {
        return n <= 1 ? 1 : climbStairs(n - 1) + climbStairs(n - 2);
    }
}