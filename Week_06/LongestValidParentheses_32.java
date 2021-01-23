class Solution {
    /**
    * DP
    * DP[i]，以i角标结尾的有效子串长度
    * ..() 当s[i]==')' && s[i - 1]=='('时，DP[i] = DP[i - 2] + 2
    * ..)) 当s[i]==')' && s[i - 1]==')' && s[i - DP[i - 1] - 1]=='('时，DP[i] = DP[i - 1] + 2 + DP[i - DP[i - 1] - 2]
    */
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length() + 1];
        for(int i = 2; i <= s.length(); i++) {
            if(s.charAt(i - 1) == ')') {
                if(s.charAt(i - 2) == '(') {
                    dp[i] = dp[i - 2] + 2;
                    max = Math.max(dp[i], max);
                } else if(i - dp[i - 1] - 2 >= 0 && s.charAt(i - dp[i - 1] - 2) == '(') {
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}