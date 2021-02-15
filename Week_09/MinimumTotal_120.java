class Solution {
    /**
    * dp[i] : 从上层走到下层i位置的最小路径和
    */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] dp = new int[n + 1];
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = triangle.get(i).size(); j >= 1; j--) {
                if(j == 1 || j == triangle.get(i).size()) {
                    dp[j] = dp[j] + dp[j - 1] + triangle.get(i).get(j - 1);
                } else{
                    dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j - 1);
                }
                if(i == m - 1) res = Math.min(res, dp[j]);
            }
        }
        return res;
    }

    /**
    * dp[i] : 从下层走到上层i位置的最小路径和
    */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] dp = new int[n + 1];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}