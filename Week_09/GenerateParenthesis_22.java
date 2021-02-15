class Solution {
    /**
    * DP
    */
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>(n + 1);// i对括号的组合结果
        List<String> list = new ArrayList<>(1);
        list.add("");
        dp.add(list);
        StringBuilder s = new StringBuilder("(");
        for(int i = 1; i <= n; i++) {// (pos1)pos2
            dp.add(list = new ArrayList<>());
            for(int j = 0; j < i; j++) {
                List<String> pos1 = dp.get(j);
                List<String> pos2 = dp.get(i - j - 1);
                for(String s1 : pos1) {
                    s.append(s1).append(")");
                    int start = s.length();
                    for(String s2 : pos2) {
                        list.add(s.append(s2).toString());
                        s.delete(start, s.length());
                    }
                    s.delete(1, s.length());
                }
            }
        }
        return dp.get(n);
    }
    
    /**
    * back track
    */
    public List<String> generateParenthesis1(int n) {
        List<String> res = new LinkedList<>();
        backTracking(res, n, 0, 0, new StringBuilder());
        return res;
    }

    private void backTracking(List<String> res, int n, int left, int right, StringBuilder s) {
        if(right == n) {
            res.add(s.toString());
            return;
        }
        if(left < n) {
            backTracking(res, n, left + 1, right, s.append('('));
            s.deleteCharAt(s.length() - 1);
        }
        if(left > right) {
            backTracking(res, n, left, right + 1, s.append(')'));
            s.deleteCharAt(s.length() - 1);
        }
    }
}