class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 ||s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            char pre = s.charAt(i - 2);
            if(c == '0') {// 当前字符为0，需要和前一个1或者2组合
                if(pre != '1' && pre != '2') return 0;
                dp[i] = dp[i - 2];
            } else if(c >= '1' && c <= '6') {// 当前字符为1-6，可以自己组合 & 与前一字符组合
                dp[i] = dp[i - 1] + (pre == '1' || pre == '2' ? dp[i - 2] : 0);
            } else {// 当前字符为7-9，若前一个字符为1，则可以组合
                dp[i] = (s.charAt(i - 2) == '1' ? dp[i - 2] : 0) + dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}