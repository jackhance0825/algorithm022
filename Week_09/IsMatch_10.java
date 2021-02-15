class Solution {
    /**
    * DP
    */
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];// 子串s[0, i] 和 正则p[0, j]是否匹配
        dp[0][0] = true;
        for(int i = 0; i <= slen; i++) {
            for(int j = 1; j <= plen; j++) {
                if(p.charAt(j - 1) == '*') {// ..a*， 0个a，或者多个a
                    dp[i][j] =  dp[i][j - 2] || (isMatch(s, p, i, j - 1) && dp[i - 1][j]);
                } else {// ..a or ...， 当前位置匹配
                    dp[i][j] = isMatch(s, p, i, j) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[slen][plen];
    }

    private boolean isMatch(String s, String p, int si, int pi) {
        return si > 0 && (p.charAt(pi - 1) == '.' || s.charAt(si - 1) == p.charAt(pi - 1));
    }
}