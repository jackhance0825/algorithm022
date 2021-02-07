class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for(int i = 1; i <= num; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for(int i = 1; i <= num; i++) {
            int c = 0;
            int n = i;
            while(n != 0) {
                n &= n - 1;
                c++;
            }
            res[i] = c;
        }
        return res;
    }
}