class Solution {
    /**
    * DP
    * DP[i][j] : word1从0到i & word2从0到i 的最短编辑距离
    * DP[i][j] = word1[i] == word2[j] ? DP[i - 1][j - 1] : min(DP[i - 1][j - 1], DP[i - 1][j], DP[i][j - 1]) + 1
    */
    public int minDistance(String word1, String word2) {
        int len1 = word1 == null ? 0 : word1.length();
        int len2 = word2 == null ? 0 : word2.length();
        if(len1 == 0 || len2 == 0) return len1 != 0 ? len1 : len2;
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];
        for(int j = 1; j <= n; j++) {
            dp[j] = j;
        }
        for(int i = 1; i <= m; i++) {
            int last = dp[0];
            dp[0] = i;
            for(int j = 1; j <= n; j++) {
                int last0 = dp[j];
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = last;
                } else {
                    dp[j] = Math.min(dp[j], Math.min(last, dp[j - 1])) + 1;
                }
                last = last0;
            }
        }
        return dp[n];
    }
    
    /**
    * DP
    * DP[i][j] : word1从0到i & word2从0到j 的最短编辑距离
    * DP[i][j] = word1[i] == word2[j] ? DP[i - 1][j - 1] : min(DP[i - 1][j - 1], DP[i - 1][j], DP[i][j - 1]) + 1
    */
    public int minDistance2(String word1, String word2) {
        int len1 = word1 == null ? 0 : word1.length();
        int len2 = word2 == null ? 0 : word2.length();
        if(len1 == 0 || len2 == 0) return len1 != 0 ? len1 : len2;
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for(int i = 1; i <= m; i++) {
            dp[i][0] = i;
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    /**
    * 回溯
    */
    public int minDistance1(String word1, String word2) {
        if((word1 == null || word1.length() == 0) && (word2 == null || word2.length() == 0)) return 0;
        return backTracking(word1.toCharArray(), word2.toCharArray(), 0, 0, 0, Integer.MAX_VALUE);
    }

    private int backTracking(char[] w1, char[] w2, int i1, int i2, int step, int minStep) {
        if(i1 == w1.length || i2 == w2.length) {
            if(i1 == w1.length) step += w2.length - i2;
            if(i2 == w2.length) step += w1.length - i1;
            return Math.min(minStep, step);    
        }
        if(step >= minStep) return minStep;
        if(w1[i1] == w2[i2]) {
            minStep = Math.min(minStep, backTracking(w1, w2, i1 + 1, i2 + 1, step, minStep));
        } else {
            // 插入w2[i2]
            minStep = Math.min(minStep, backTracking(w1, w2, i1, i2 + 1, step + 1, minStep));
            // 删除w1[i1]
            minStep = Math.min(minStep, backTracking(w1, w2, i1 + 1, i2, step + 1, minStep));
            // 替换w1[i1]成w2[i2]
            minStep = Math.min(minStep, backTracking(w1, w2, i1 + 1, i2 + 1, step + 1, minStep));
        }
        return minStep;
    }
}