class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];// 子串s[0, i] 和 正则p[0, j]是否匹配
        dp[0][0] = true;
        for(int i = 1; i <= plen; i++) {
            if(p.charAt(i - 1) != '*') break;
            dp[0][i] = true;
        }
        for(int i = 1; i <= slen; i++) {
            for(int j = 1; j <= plen; j++) {
                if(p.charAt(j - 1) == '*') {// ..*
                    dp[i][j] = dp[i][j - 1] // s:aa p:aa*
                             || dp[i - 1][j];// s:aa p:a*
                } else {// ..? or ..a
                    dp[i][j] = (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[slen][plen];
    }
}