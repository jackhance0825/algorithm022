class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        dfs(0, 0, n, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(int left, int right, int n, StringBuilder s, List<String> ans) {
        if(right == n) {
            ans.add(s.toString());
            return;
        }
        if(left < n) {
            dfs(left + 1, right, n, s.append('('), ans);
            s.deleteCharAt(s.length() - 1);
        }
        if(right < left) {
            dfs(left, right + 1, n, s.append(')'), ans);
            s.deleteCharAt(s.length() - 1);
        }
    }
}