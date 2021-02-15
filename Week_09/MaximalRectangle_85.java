class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] dp = new int[m];// 每一行的面积
        for(int col = 0; col < n; col++) {
            // 计算每一行的面积
            for(int row = 0; row < m; row++) {
                int v = matrix[row][col] - '0';
                dp[row] = v == 0 ? 0 : dp[row] + v;
            }
            // 计算最大矩形面积
            max = Math.max(max, maximalRectangle(dp));
        }
        return max;
    }

	// 85题求柱状图最大矩形面积
    private int maximalRectangle(int[] heights) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for(int i = 0; i < heights.length; i++) {
            while(stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while(stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return max;
    }
}