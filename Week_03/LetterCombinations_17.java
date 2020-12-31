class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();
        if(digits == null || digits.length() == 0) {
            return ans;
        }
        Map<Character, String> map = new HashMap<>(8, 1);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(digits, map, 0, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(String digits, Map<Character, String> map, int i, StringBuilder s, List<String> ans) {
        if(i == digits.length()) {
            ans.add(s.toString());
            return;
        }
        String str = map.get(digits.charAt(i));
        for(int j = 0; j < str.length(); j++) {
            backtrack(digits, map, i + 1, s.append(str.charAt(j)), ans);
            s.deleteCharAt(s.length() - 1);
        }
    }
}