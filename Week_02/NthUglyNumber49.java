class Solution {
    /**
     * 动态规划，借助3指针
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public int nthUglyNumber2(int n) {
        int[] dp = new int[n < 1690 ? n : 1690];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for(int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if(dp[i] == dp[p2] * 2) p2++;
            if(dp[i] == dp[p3] * 3) p3++;
            if(dp[i] == dp[p5] * 5) p5++;
        }
        return dp[n - 1];
    }

    /**
     * 优先队列
     * 时间复杂度O(nlogk)，k为优先队列的高度
     * 空间复杂度O(n)
     */
    public int nthUglyNumber1(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        heap.offer(1L);
        visited.add(1L);
        long ans = 0L;
        while(n-- > 0) {
            ans = heap.poll();
            if(visited.add(ans * 2)) heap.offer(ans * 2);
            if(visited.add(ans * 3)) heap.offer(ans * 3);
            if(visited.add(ans * 5)) heap.offer(ans * 5);
        }
        return (int)ans;
    }
}
