class Solution {
    private void dfs(List<List<Integer>> ans, Deque<Integer> q, int cur, int n, int k) {
        if(k == 0) {
            ans.add(new ArrayList<>(q));
            return;
        }
        while(++cur <= n - k + 1) {
            q.offer(cur);
            dfs(ans, q, cur, n, k - 1);
            q.pollLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        Deque<Integer> q = new LinkedList<>();
        dfs(ans, q, 0, n, k);
        return ans;
    }
}