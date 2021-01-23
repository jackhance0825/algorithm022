class Solution {
    /**
    * DP
    * DP[i] ：正整数i由最少完全平方数组成最少个数
    * DP[i] = min(DP[i - 1], DP[i - 4], DP[i - 9], ..., DP[i - K]) + 1 (K 是最接近（不大于）i的完全平方数)
    */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int s = 1;
        int square = 1;
        int nextSquare = 4;
        for(int i = 2; i <= n; i++) {
            if(i == nextSquare) {
                square = nextSquare;
                s++;
                nextSquare = (s + 1) * (s + 1);
            }
            int min = dp[i - 1];
            for(int j = 2; j <= s; j++) {
                min = Math.min(dp[i - j * j], min);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}