class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word1.length() == 0) {
            return word2 == null ? 0 : word2.length();
        } else if(word2 == null || word2.length() == 0) {
            return word1 == null ? 0 : word1.length();
        }
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];// text1.substring(0, i) 和 text2.substring(0, j)的最小编辑距离
        for(int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for(int i = 1; i <= m; i++) {
            dp[i][0] = i;
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}