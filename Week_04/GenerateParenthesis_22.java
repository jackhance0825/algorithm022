class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        if(n <= 0) {
            return ans;
        }
        dfs(ans, n, new StringBuilder(), 0, 0);
        return ans;
    }

    private void dfs(List<String> ans, int n, StringBuilder s, int left, int right) {
        if(right == n) {
            ans.add(s.toString());
            return;
        }
        if(left < n) {
            dfs(ans, n, s.append('('), left + 1, right);
            s.deleteCharAt(s.length() - 1);
        }
        if(right < left) {
            dfs(ans, n, s.append(')'), left, right + 1);
            s.deleteCharAt(s.length() - 1);
        }
    }
}