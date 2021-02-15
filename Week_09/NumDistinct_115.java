class Solution {
    
    /**
    * DP
    * DP[i][j] : t[0, i] 和 s[0, j] 的方案总数
    */
    public int numDistinct(String s, String t) {
        if(s == null || s.length() == 0) return t == null || t.length() == 0 ? 1 : 0;
        if(t == null || t.length() == 0) return 1;
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for(int j = 0; j <= s.length(); j++) dp[0][j] = 1;
        for(int i = 1; i <= t.length(); i++) {
            for(int j = i; j <= s.length(); j++) {
                dp[i][j] = t.charAt(i - 1) == s.charAt(j - 1) ? dp[i - 1][j - 1] + dp[i][j - 1] : dp[i][j - 1];
            }
        }
        return dp[t.length()][s.length()];
    }
}