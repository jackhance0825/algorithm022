class Solution {

    /**
    * DP[i][j]: 字符串text1的子串[0,i] 和字符串text2的子串[0,j]的最长公共子序列长度
    * DP[i][j] = text1[i] == text2[j] ? DP[i - 1][j - 1] + 1 : max(DP[i - 1][j], DP[i][j - 1])
    * 压缩空间
    */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp0 = new int[n + 1];
        int[] dp = new int[n + 1];
        for(int i = 1; i <= m; i++) {
            int[] temp = dp0;
            dp0 = dp;
            dp = temp;
            for(int j = 1; j <= n; j++) {
                dp[j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? dp0[j - 1] + 1 : Math.max(dp0[j], dp[j - 1]);
            }
        }
        return dp[n];
    }

    /**
    * DP[i][j]: 字符串text1的子串[0,i] 和字符串text2的子串[0,j]的最长公共子序列长度
    * DP[i][j] = text1[i] == text2[j] ? DP[i - 1][j - 1] + 1 : max(DP[i - 1][j], DP[i][j - 1])
    * TimeComplexity: O(m*n), m = text1.length, n = text2.length
    */
    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}