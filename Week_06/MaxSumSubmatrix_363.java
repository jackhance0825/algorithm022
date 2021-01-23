class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int max = Integer.MIN_VALUE;      
        int m = matrix.length;
        int n = matrix[0].length;
        int[] sum = new int[m];
        // 设立左右界，结合最大子序和计算最大面积
        for(int left = 0; left < n; left++) {
            for(int right = left; right < n; right++) {
                for(int i = 0; i < m; i++) {
                    sum[i] = right == left ? matrix[i][right] : sum[i] + matrix[i][right];
                }
                max = Math.max(max, findMax(sum, k));
            }
        }
        return max;
    }

    private int findMax(int[] sum, int k) {
        // 先尝试最大子序和求最大值，看是否符合k
        int dp = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < sum.length; i++) {
            dp = dp < 0 ? sum[i] : dp + sum[i];
            max = Math.max(max, dp);
        }
        if(max <= k) return max;
        // 不符合，穷举
        dp = 0;
        max = Integer.MIN_VALUE;
        for(int i = 0; i < sum.length; i++) {
            dp = sum[i];
            if(dp  <= k) max = Math.max(max, dp);
            for(int j = i + 1; j < sum.length; j++) {
                dp += sum[j];
                if(dp  <= k) max = Math.max(max, dp);
            }
        }
        return max;
    }
}