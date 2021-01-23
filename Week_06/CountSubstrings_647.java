class Solution {
    
    /**
    * 迭代：由中间往外扩散
    */
    public int countSubstrings0(String s) {
        int n = s.length();
        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= 1; j++) {
                int left = i;
                int right = i + j;
                while(left >= 0 && right < n && s.charAt(left--) == s.charAt(right++)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    /**
    * DP
    * dp[i][j] : 从i到j是否为回文子串
    * ...a: 当为单个字符时，true
    * ...aa: 当俩个相邻字符相同时，true
    * ...abba : 当跨越多个时，true
    */
    public int countSubstrings(String s) {
        int sum = 0;
        boolean[] dp = new boolean[s.length()];
        for(int j = 0; j < s.length(); j++) {
            for(int i = 0; i <= j; i++) {
                if(dp[i] = s.charAt(i) == s.charAt(j) && (i == j // 单个
                || j - i == 1 // 相邻字符相同
                || (j - i > 1 && dp[i + 1]))) {// 跨越多个
                    sum++;
                }
            }
        }
        return sum;
    }

    /**
    * DP
    * dp[i][j] : 从i到j是否为回文子串
    * ...a: 当为单个字符时，true
    * ...aa: 当俩个相邻字符相同时，true
    * ...abba : 当跨越多个时，true
    */
    public int countSubstrings1(String s) {
        int sum = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int j = 0; j < s.length(); j++) {
            for(int i = 0; i <= j; i++) {
                if(s.charAt(i) != s.charAt(j)) continue;
                if(i == j) {// 单个
                    dp[i][j] = true;
                    sum++;
                } else if(j - i == 1) {// 相邻字符相同
                    dp[i][j] = true;
                    sum++;
                } else if(j - i > 1 && dp[i + 1][j - 1]) {// 跨越多个
                    dp[i][j] = true;
                    sum++;
                }
            }
        }
        return sum;
    }
}