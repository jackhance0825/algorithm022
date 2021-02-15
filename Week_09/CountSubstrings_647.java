class Solution {
    /**
    * DP
    */
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];// i 到 j为回文字符串
        int res = 0;
        for(int j = 0; j < s.length(); j++) {
            for(int i = 0; i <= j; i++) {
                if(s.charAt(i) != s.charAt(j)) continue;
                if(dp[i][j] = i == j || j - i == 1 || dp[i + 1][j - 1]) res++;
            }
        }
        return res;
    }

    /**
    * 迭代
    */
    public int countSubstrings1(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            res += countSubstrings(s, i, i);
            res += countSubstrings(s, i, i + 1);
        }
        return res;
    }

    private int countSubstrings(String s, int left, int right) {
        int res = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            res++;
            left--;
            right++;
        }
        return res;
    }
}