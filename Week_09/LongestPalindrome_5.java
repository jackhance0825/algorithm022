class Solution {
    /**
    * DP
    * DP[i][j] : i到j为回文字符串
    * ..a
    * ..aa
    * ..abba
    */
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = null;
        for(int j = 0; j < s.length(); j++) {
            for(int i = 0; i <= j; i++) {
                if(s.charAt(i) != s.charAt(j)) continue;
                if(i == j) {// ..a
                    dp[i][j] = true;
                } else if(j - i == 1) {// ..aa
                    dp[i][j] = true;
                } else if(dp[i + 1][j - 1]) { // ..abba
                    dp[i][j] = true;
                }
                if(dp[i][j] && (res == null || res.length() < j - i + 1)) res = s.substring(i, j + 1);
            }
        }
        return res;
    }

    /**
    * 迭代
    */
    public String longestPalindrome1(String s) {
        String res = null;
        for(int i = 0; i < s.length(); i++) {
            res = longestPalindrome(s, i, i, res);
            res = longestPalindrome(s, i, i + 1, res);
        }
        return res;
    }

    private String longestPalindrome(String s, int left, int right, String res) {
        while(left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return res == null || res.length() < right - left - 1 ? s.substring(left + 1, right) : res;
    }
}