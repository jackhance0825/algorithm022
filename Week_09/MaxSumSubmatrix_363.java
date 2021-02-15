class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] sum = new int[m];
        int max = Integer.MIN_VALUE;
        for(int left = 0; left < n; left++) {
            for(int right = left; right < n; right++) {
                for(int row = 0; row < m; row++) {
                    sum[row] = (left == right ? 0 : sum[row]) + matrix[row][right];
                }
                max = Math.max(max, findMax(sum, k));
            }
        }
        return max;
    }

    private int findMax(int[] sum, int k) {
        // 最大子序和是否符合
        int max = Integer.MIN_VALUE;
        int dp = 0;
        for(int i = 0; i < sum.length; i++) {
            dp = dp < 0 ? sum[i] : dp + sum[i];
            max = Math.max(max, dp);
        }
        if(max <= k) return max;
        // 穷举
        max = Integer.MIN_VALUE;
        dp = 0;
        for(int i = 0; i < sum.length; i++) {
            dp = 0;
            for(int j = i; j < sum.length; j++) {
                dp += sum[j];
                if(dp <= k) max = Math.max(max, dp);
            }
        }
        return max;
    }
}