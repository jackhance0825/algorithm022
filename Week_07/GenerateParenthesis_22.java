class Solution {
    /**
    * DP
    * (.{p}.)..{q}
    * DP[n] = DP[q] + DP[q] + 1
    * TimeComplexity: O(2^n)
    */
    public List<String> generateParenthesis(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> s1 = new LinkedList<>();
        s1.add("");
        res.add(s1);
        s1 = new LinkedList<>();
        s1.add("()");
        res.add(s1);
        
        StringBuilder cs = new StringBuilder("(");
        for(int i = 2; i <= n; i++) {
            List<String> list = new LinkedList<>();
            res.add(list);
            for(int p = 0; p <= i - 1; p++) {
                int q = i - 1 - p;
                for(String sp: res.get(p)) {
                    cs.append(sp).append(')');
                    for(String sq: res.get(q)) {
                        cs.append(sq);
                        list.add(cs.toString());
                        cs.delete((p + 1) * 2, cs.length());
                    }
                    cs.delete(1, cs.length());
                }
            }
        }
        return res.get(n);
    }

    /**
    * 回溯&剪枝
    * TimeComplexity: O(2^n)
    */
    public List<String> generateParenthesis1(int n) {
        List<String> res = new LinkedList<>();
        backTracking(res, n, 0, 0, new char[2 * n]);
        return res;
    }

    private void backTracking(List<String> res, int n, int left, int right, char[] cs) {
        if(right == n) {
            res.add(new String(cs));
            return;
        }
        if(left < n) {
            cs[left + right] = '(';
            backTracking(res, n, left + 1, right, cs);
        }
        if(right < left) {
            cs[left + right] = ')';
            backTracking(res, n, left, right + 1, cs);
        }
    }
}