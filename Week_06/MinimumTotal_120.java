class Solution {
    /**
    * DP
    * DP[j]: 自底向上从左到右,走到j列的最小路径和
    * DP[j] = min(DP[j], DP[j + 1]) + triangle[i][j]
    */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] dp = new int[n + 1];
        for(int i = m - 1; i >= 0; i--) {
            int len = triangle.get(i).size();
            for(int j = 0; j < len; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    /**
    * DP
    * DP[i][j]: 从最后一行走到(i,j)的最小路径和
    * DP[i][j] = min(DP[i + 1][j], DP[i + 1][j + 1]) + triangle[i][j]
    */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = triangle.get(i).size() - 1; j >= 0; j--) {
                dp[i][j] = i == m - 1 ? triangle.get(i).get(j)
                 : Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}