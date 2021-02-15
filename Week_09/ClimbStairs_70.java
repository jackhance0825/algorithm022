class Solution {
    /**
    * DP
    * State Compression
    */
    public int climbStairs(int n) {
        int a = 1, b = 1, res = 1;
        for(int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

    /**
    * DP
    */
    public int climbStairs3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
    /**
    * memorized DFS
    */
    public int climbStairs2(int n) {
        int[] mem = new int[n + 1];
        mem[0] = mem[1] = 1;
        return dfs(n, mem);
    }

    private int dfs(int n, int[] mem) {
        if(mem[n] > 0) return mem[n];
        return mem[n] = dfs(n - 1, mem) + dfs(n - 2, mem);
    }

    /**
    * Naive Recursion
    */
    public int climbStairs1(int n) {
        return n <= 2 ? n : climbStairs(n - 1) + climbStairs(n - 2);
    }
}