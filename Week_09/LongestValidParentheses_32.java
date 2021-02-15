class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() <= 1) return 0;
        int[] dp = new int[s.length() + 1];
        int max = 0;
        for(int i = 2; i <= s.length(); i++) {
            if(s.charAt(i - 1) == ')') {
                if(s.charAt(i - 2) == '(') {// ...()
                    dp[i] = dp[i - 2] + 2;
                } else {// ....()((..))
                    if(i - dp[i - 1] - 2 >= 0 && s.charAt(i - dp[i - 1] - 2) == '(') {
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}