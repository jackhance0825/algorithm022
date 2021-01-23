class Solution {
    /**
    * DP
    * DP[i] : 子串[0, i]的解码总数
    * DP[i] = c[i - 1] == '1'， 则c[i] == '0' ? DP[i - 2] : DP[i - 1] + DP[i - 2]
    *         c[i - 1] == '2',  则 c[i] == '0' ? DP[i - 2] :  c[i] <= '6' ? DP[i - 1] + DP[i - 2] : DP[i - 1]
    *         其他情况下, 则c[i] == '0' ? return 0   : DP[i - 1]
    */
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            char prev = s.charAt(i - 2);
            if(prev == '1') {
                dp[i] = c == '0' ? dp[i - 2] : dp[i - 1] + dp[i - 2];
            } else if(prev == '2') {
                dp[i] = c == '0' ? dp[i - 2] : c <= '6' ? dp[i - 1] + dp[i - 2] : dp[i - 1];
            } else {
                if(c == '0') return 0;
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}